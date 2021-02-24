package com.openclassroom.paymybuddywebapp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PorteMonnaie {

    private int porteMonnaieId ;

    private int soldes ;

    private boolean available ;

    private int addOrSoustract ;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setSoldes(int soldes) {
        this.soldes = soldes;
    }

    public int getAddOrSoustract() {
        return addOrSoustract;
    }
}
