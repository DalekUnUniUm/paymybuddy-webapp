package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.repository.UtilisateurProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurProxy utilisateurProxy ;

    public String userExist(String mail){
        return utilisateurProxy.userExist(mail);
    }

    public String login(String mail, String password){
        return utilisateurProxy.login(mail,password);
    }

    public Utilisateur saveUser(Utilisateur utilisateur){
        Utilisateur savedUser ;
        savedUser = utilisateurProxy.createUser(utilisateur);
        return savedUser ;
    }

    public Utilisateur getUtilisateur(final int id){
        return utilisateurProxy.getUtilisateur(id);
    }

    public String firstNameByUserId(String utilisateurId){
        return utilisateurProxy.firstNameByUserId(utilisateurId);
    }

    public String utilisateurIdByName(String firstName){
        return utilisateurProxy.utilisateurIdByName(firstName);
    }

    public int soldesIdByUserId(int utilisateurId){
        return utilisateurProxy.soldesIdByUserId(utilisateurId);
    }

    public String idByEmail(String email){
        return utilisateurProxy.idByEmail(email);
    }

}
