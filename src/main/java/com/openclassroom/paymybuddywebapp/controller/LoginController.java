package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private Utilisateur utilisateur ;

    @Autowired
    private UtilisateurService utilisateurService ;

    @GetMapping("/login")
    public String login(@CookieValue(value = "utilisateurId", defaultValue = "null") String utilisateurId, Model model){
        utilisateur = new Utilisateur();
        utilisateur.setRememberMe(false);
        model.addAttribute("rememberme",utilisateur.getRememberMe());
        model.addAttribute("utilisateur", utilisateur);
        if(!utilisateurId.equals("null"))
            return "/home" ;

        return "login" ;
    }

    @PostMapping("/login")
    public ModelAndView verifiedLogin(@ModelAttribute Utilisateur utilisateur, Model model, HttpServletResponse response){

        System.out.println("checked = " + utilisateur.getRememberMe());

        if(utilisateurService.userExist(utilisateur.getMail()) == null){
            model.addAttribute("logError", "logError");
            return new ModelAndView("/login") ;
        }
        String getId = utilisateurService.login(utilisateur.getMail(),utilisateur.getPassword());
        if(getId == null){
            model.addAttribute("logError", "logError");
            return new ModelAndView("/login") ;
        }

        if(utilisateur.getRememberMe() == false){
            Cookie cookie = new Cookie("utilisateurId", getId);
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);
        }


        return new ModelAndView("/home") ;
    }
}
