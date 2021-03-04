package com.openclassroom.paymybuddywebapp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PorteMonnaie {

    private int porteMonnaieId ;

    private double soldes ;

    private boolean available ;

    private String bankAccount ;

    private int addOrSoustract ;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setSoldes(double soldes) {
        this.soldes = soldes;
    }

    public int getAddOrSoustract() {
        return addOrSoustract;
    }

    public String getBankAccount() {
        return bankAccount;
    }
}
