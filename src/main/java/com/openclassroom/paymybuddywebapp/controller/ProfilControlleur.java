package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.PorteMonnaie;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.PorteMonnaieService;
import com.openclassroom.paymybuddywebapp.service.ReseauService;
import com.openclassroom.paymybuddywebapp.service.UtilisateurService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfilControlleur {

    @Autowired
    private PorteMonnaie porteMonnaie ;
    @Autowired
    private Utilisateur utilisateur ;

    @Autowired
    private PorteMonnaieService porteMonnaieService ;
    @Autowired
    private UtilisateurService utilisateurService ;
    @Autowired
    private ReseauService reseauService ;

    private JSONObject listFriend ;

    @GetMapping("/profil")
    public String profil(@CookieValue("utilisateurId") String utilisateurId, Model model){

        porteMonnaie = new PorteMonnaie();
        utilisateur = new Utilisateur();
        utilisateur = utilisateurService.getUtilisateur(Integer.valueOf(utilisateurId));
        porteMonnaie.setSoldes(Double.valueOf(porteMonnaieService.mySolde(Integer.valueOf(utilisateurId))));
        listFriend = reseauService.listFriendId(utilisateur.getUtilisateur_id());
        model.addAttribute("porteMonnaie",porteMonnaie);
        model.addAttribute("utilisateurs",utilisateur);
        model.addAttribute("listFriends",listFriend.get("firstName"));
        return "profil" ;
    }

    @RequestMapping(value = "/addmoney", method = RequestMethod.POST)
    public String addMoney(@ModelAttribute("addmoney") PorteMonnaie porteMonnaie, Model model){
        System.out.println("Sommes = " + porteMonnaie.getAddOrSoustract());
        System.out.println("bankaccount = " + porteMonnaieService.getBankAccount(utilisateur.getSoldesId()));
        if(porteMonnaieService.getBankAccount(utilisateur.getSoldesId()).equals("0")){
            model.addAttribute("logError", "logError");
            System.out.println("Link a bank account !");
            return "redirect:/profil" ;
        }
        porteMonnaieService.addSoldes(porteMonnaie.getAddOrSoustract(), utilisateur.getSoldesId());

        return "redirect:/profil" ;
    }

    @RequestMapping(value = "/addmoneytobank", method = RequestMethod.POST)
    public String addMoneyToBank(@ModelAttribute("addmoneytobank") PorteMonnaie porteMonnaie, Model model){
        System.out.println("Sommes = " + porteMonnaie.getAddOrSoustract());
        if(porteMonnaieService.getBankAccount(utilisateur.getSoldesId()).equals("0")){
            model.addAttribute("logError", "logError");
            System.out.println("Link a bank account !");
            return "redirect:/profil" ;
        }
        porteMonnaieService.soustractSoldes(porteMonnaie.getAddOrSoustract(), utilisateur.getSoldesId());

        return "redirect:/profil" ;
    }

}
