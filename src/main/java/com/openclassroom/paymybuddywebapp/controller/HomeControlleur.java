package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes
public class HomeControlleur {

    @Autowired
    private HomeService homeService ;

    @GetMapping("/home")
    public ModelAndView getUtilisateur(@CookieValue("utilisateurId") String utilisateurId, Model model){

        System.out.println("Cookie = " + utilisateurId);
        Utilisateur u = homeService.getUtilisateur(Integer.valueOf(utilisateurId));

        System.out.println("Utilisateur = " + utilisateurId);

        model.addAttribute("utilisateur", u);

        System.out.println("utilisateur " + u);

        return new ModelAndView("/home");
    }
}
