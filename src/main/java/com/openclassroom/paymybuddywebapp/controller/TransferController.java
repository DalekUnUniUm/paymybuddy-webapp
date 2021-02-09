package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransferController {

    @Autowired
    private Utilisateur u ;

    @GetMapping("/home/transfer")
    public String tranfer(@CookieValue("utilisateurId") String utilisateurId){
        System.out.println("Utilisateur = " + utilisateurId);
        return "transfer" ;
    }

}
