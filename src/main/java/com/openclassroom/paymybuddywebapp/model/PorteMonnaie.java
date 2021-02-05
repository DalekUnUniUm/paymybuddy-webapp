package com.openclassroom.paymybuddywebapp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class PorteMonnaie {

    private int porteMonnaieId ;

    private int soldes ;

    private boolean available ;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getSoldes() {
        return soldes;
    }

    public void setSoldes(int soldes) {
        this.soldes = soldes;
    }
}
