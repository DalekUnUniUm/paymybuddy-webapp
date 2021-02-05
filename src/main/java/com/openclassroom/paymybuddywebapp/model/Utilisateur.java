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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }
}
