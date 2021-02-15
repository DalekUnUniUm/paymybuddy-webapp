package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.model.PorteMonnaie;
import com.openclassroom.paymybuddywebapp.repository.PorteMonnaieProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;

@Service
public class PorteMonnaieService {

    @Autowired
    private PorteMonnaieProxy porteMonnaieProxy ;

    public PorteMonnaie savePorteMonnaie(PorteMonnaie porteMonnaie){
        PorteMonnaie savedPorteMonnaie ;
        savedPorteMonnaie = porteMonnaieProxy.createPorteMonnaie(porteMonnaie);
        return savedPorteMonnaie ;
    }

    public String mySolde(int utilisateurId){
        return porteMonnaieProxy.mySolde(utilisateurId);
    }

    public void addSoldes(int sommes, int utilisateurSoldesId){
        porteMonnaieProxy.addSoldes(sommes, utilisateurSoldesId);
    }

    public void soustractSoldes(int sommes, int utilisateurSoldesId){
        porteMonnaieProxy.soustractSoldes(sommes, utilisateurSoldesId);
    }

}
