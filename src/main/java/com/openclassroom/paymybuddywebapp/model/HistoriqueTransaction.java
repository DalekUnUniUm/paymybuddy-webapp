package com.openclassroom.paymybuddywebapp.model;

import lombok.Data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Data
@Component
public class HistoriqueTransaction {

    private int utilisateurId ;
    private String utilisateurIdFriends ;
    private String firstName ;
    private String description ;
    private int amount ;

    public String getFirstName() {
        return firstName;
    }

    public String getUtilisateurIdFriends() {
        return utilisateurIdFriends;
    }

    public void setUtilisateurIdFriends(String utilisateurIdFriends) {
        this.utilisateurIdFriends = utilisateurIdFriends;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public int getAmount() {
        return amount;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
