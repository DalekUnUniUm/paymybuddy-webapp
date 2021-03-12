package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.Reseau;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.ReseauService;
import com.openclassroom.paymybuddywebapp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReseauController {

    @Autowired
    private UtilisateurService utilisateurService ;

    @Autowired
    private Utilisateur utilisateur ;

    @Autowired
    private ReseauService reseauService ;

    @Autowired
    private Reseau reseau ;

    @GetMapping("/reseau")
    public String login(@CookieValue(value = "utilisateurId", defaultValue = "null") String utilisateurId, Model model){
        utilisateur = utilisateurService.getUtilisateur(Integer.valueOf(utilisateurId));
        model.addAttribute("reseau", reseau);
        return "reseau" ;
    }

    @PostMapping("/reseau")
    public ModelAndView addfriends(@CookieValue("utilisateurId") String utilisateurId, @ModelAttribute Reseau reseau, Model model){
        if(utilisateurService.userExist(reseau.getMail()) == null){
            model.addAttribute("logError", "logError");
            return new ModelAndView("/reseau") ;
        }

        String emailFriendId = utilisateurService.idByEmail(reseau.getMail());

        if(reseauService.isFriend(utilisateur.getUtilisateur_id(), Integer.valueOf(emailFriendId)) == 1){
            model.addAttribute("logError2", "logError2");
            return new ModelAndView("/reseau") ;
        }

        reseau.setUserA(utilisateur.getUtilisateur_id());
        reseau.setUserB(Integer.valueOf(emailFriendId));

        reseauService.saveUser(reseau);

        return new ModelAndView("redirect:/transfer");
    }
}
