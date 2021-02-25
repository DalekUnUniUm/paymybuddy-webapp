package com.openclassroom.paymybuddywebapp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Reseau {

    private int userAId ;
    private int userBId ;
    private String mail ;

    public void setUserA(int userA) {
        this.userAId = userA;
    }

    public void setUserB(int userB) {
        this.userBId = userB;
    }

    public String getMail() {
        return mail;
    }
}
