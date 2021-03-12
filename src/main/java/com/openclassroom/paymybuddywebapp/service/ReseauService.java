package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.model.Reseau;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.repository.ReseauProxy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReseauService {
    @Autowired
    private ReseauProxy reseauProxy ;

    public Reseau saveUser(Reseau reseau){
        Reseau savedReseau ;
        savedReseau = reseauProxy.createUser(reseau);
        return savedReseau ;
    }

    public JSONObject listFriendId(int utilisateurId){
        return reseauProxy.listFriendId(utilisateurId);
    }

    public int isFriend(int userId , int userFriendId){
        return reseauProxy.isFriend(userId,userFriendId);
    }
}
