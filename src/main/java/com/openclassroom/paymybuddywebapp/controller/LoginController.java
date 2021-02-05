package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.GenericRequestService;
import com.openclassroom.paymybuddywebapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private Utilisateur utilisateur ;
    @Autowired
    private GenericRequestService genericRequestService ;
    @Autowired
    private LoginService loginService ;

    @GetMapping("/login")
    public String login(Model model){
        utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        return "login" ;
    }

    @PostMapping("/login")
    public ModelAndView verifiedLogin(@ModelAttribute Utilisateur utilisateur, Model model){

        if(genericRequestService.userExist(utilisateur.getMail()) == null){
            model.addAttribute("logError", "logError");
            return new ModelAndView("/login") ;
        }
        String getId = loginService.login(utilisateur.getMail(),utilisateur.getPassword());
        if(getId == null){
            model.addAttribute("logError", "logError");
            return new ModelAndView("/login") ;
        }
        System.out.println("getID = " + getId);
        utilisateur.setUtilisateur_id(Integer.valueOf(getId));

        return new ModelAndView("redirect:/home/"+getId) ;
    }
}
