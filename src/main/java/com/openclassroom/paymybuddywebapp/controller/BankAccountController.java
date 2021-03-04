package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.PorteMonnaie;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.PorteMonnaieService;
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
public class BankAccountController {

    @Autowired
    private PorteMonnaie porteMonnaie ;

    @Autowired
    private Utilisateur utilisateur ;

    @Autowired
    private UtilisateurService utilisateurService ;

    @Autowired
    private PorteMonnaieService porteMonnaieService ;

    @GetMapping("/bankaccount")
    public String bankAccount(Model model){

        model.addAttribute("portemonnaie", porteMonnaie);

        return "bankaccount" ;
    }

    @PostMapping("/bankaccount")
    public String updateBankAccount(@ModelAttribute PorteMonnaie porteMonnaie,@CookieValue("utilisateurId") String utilisateurId){

        utilisateur = utilisateurService.getUtilisateur(Integer.valueOf(utilisateurId));
        System.out.println("bankaccount = " + porteMonnaie.getBankAccount());
        System.out.println("soldeId = " + utilisateur.getSoldesId());
        porteMonnaieService.updateBankAccount(porteMonnaie.getBankAccount(), utilisateur.getSoldesId());

        return "redirect:/profil";

    }

}
