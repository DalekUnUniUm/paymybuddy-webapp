package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.HistoriqueTransaction;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.HistoriqueTransactionService;
import com.openclassroom.paymybuddywebapp.service.HomeService;
import com.openclassroom.paymybuddywebapp.service.PorteMonnaieService;
import com.openclassroom.paymybuddywebapp.service.ReseauService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransferController {

    @Autowired
    private HistoriqueTransaction historiqueTransaction;

    @Autowired
    private HistoriqueTransactionService historiqueTransactionService ;

    @Autowired
    private Utilisateur utilisateur ;

    @Autowired
    private HomeService homeService ;

    @Autowired
    private PorteMonnaieService porteMonnaieService ;

    @Autowired
    private ReseauService reseauService ;

    private JSONObject listFriend ;

    @GetMapping("/transfer")
    public String tranfer(@CookieValue("utilisateurId") String utilisateurId, Model model){
        utilisateur = homeService.getUtilisateur(Integer.valueOf(utilisateurId));
        listFriend = reseauService.listFriendId(utilisateur.getUtilisateur_id());
        model.addAttribute("friends",listFriend.get("firstName"));
        historiqueTransaction = new HistoriqueTransaction();
        model.addAttribute("historiqueTransaction", historiqueTransaction);

        return "transfer" ;
    }

    @PostMapping("/transfer")
    public ModelAndView transfer(@CookieValue("utilisateurId") String utilisateurId, @ModelAttribute HistoriqueTransaction historiqueTransaction, Model model){
        if(Integer.valueOf(porteMonnaieService.mySolde(utilisateur.getUtilisateur_id())) < historiqueTransaction.getAmount()) {
            model.addAttribute("logError", "logError");
            return new ModelAndView("/transfer");
        }

        System.out.println("id = " + reseauService.utilisateurIdByName(historiqueTransaction.getFirstName()));
        historiqueTransaction.setUtilisateurId(Integer.valueOf(utilisateurId));
        historiqueTransaction.setUtilisateurIdFriends(reseauService.utilisateurIdByName(historiqueTransaction.getFirstName()));
        /**On retire dans le porte monnaie la somme du débiteur dans la colonne soldes, par rapport à son ID solde**/
        porteMonnaieService.soustractSoldes(historiqueTransaction.getAmount(), utilisateur.getSoldesId());
        /**On ajoute dans le porte monnaie la somme du crediteur dans la colonne soldes, par rapport à son ID solde**/
        porteMonnaieService.addSoldes(historiqueTransaction.getAmount(), reseauService.soldesIdByUserId(Integer.valueOf(historiqueTransaction.getUtilisateurIdFriends())));
        System.out.println("HistoriqueTransaction = " + historiqueTransaction);
        historiqueTransactionService.saveHistorique(historiqueTransaction);
        model.addAttribute("logSuccess", "logError");

        return new ModelAndView("/transfer");
    }
}
