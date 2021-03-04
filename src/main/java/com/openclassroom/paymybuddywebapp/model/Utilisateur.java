package com.openclassroom.paymybuddywebapp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Utilisateur {

    private int utilisateur_id ;

    private String mail ;

    private String password ;

    private String lastName ;

    private String firstName ;

    private int soldesId ;

    private boolean rememberMe ;

    public String getMail() {
        return mail;
    }


    public String getPassword() {
        return password;
    }


    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public int getSoldesId() {
        return soldesId;
    }

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
