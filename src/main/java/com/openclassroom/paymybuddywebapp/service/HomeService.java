package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.repository.HomeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

     @Autowired
     private HomeProxy homeProxy;

     public Utilisateur getUtilisateur(final int id){
         return homeProxy.getUtilisateur(id);
     }
}
