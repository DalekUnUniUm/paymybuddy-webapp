package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeControlleur {

    @Autowired
    private HomeService homeService ;

    @GetMapping("/home/{id}")
    public String getUtilisateur(@PathVariable("id") int utilisateurId, Model model){

        System.out.println("getID = " + utilisateurId);
        Utilisateur u = homeService.getUtilisateur(utilisateurId);

        System.out.println("Utilisateur = " + utilisateurId);

        model.addAttribute("utilisateur", u);

        System.out.println("utilisateur " + u);

        return "home" ;
    }
}
