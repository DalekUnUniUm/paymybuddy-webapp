package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.PorteMonnaie;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.service.PorteMonnaieService;
import com.openclassroom.paymybuddywebapp.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    @Autowired
    private Utilisateur utilisateur ;
    @Autowired
    private UtilisateurService utilisateurService ;
    @Autowired
    private PorteMonnaie porteMonnaie ;
    @Autowired
    private PorteMonnaieService porteMonnaieService ;

    @GetMapping("/register")
    public String register(Model model){
        utilisateur = new Utilisateur();
        model.addAttribute("utilisateur",utilisateur);
        return "register" ;
    }

    @PostMapping("/register")
    public ModelAndView saveUser(@ModelAttribute Utilisateur utilisateur, Model model){

        if(utilisateurService.userExist(utilisateur.getMail()) != null){
            model.addAttribute("logError", "logError");
            return new ModelAndView("/register");
        }
        /**Création du porte Monnaie**/
        porteMonnaie.setSoldes(0);
        porteMonnaie.setAvailable(true);

        porteMonnaieService.savePorteMonnaie(porteMonnaie);
        /**Enregistrement de l'utilisateur**/
        utilisateurService.saveUser(utilisateur);
        return new ModelAndView("redirect:/login");
    }
}
