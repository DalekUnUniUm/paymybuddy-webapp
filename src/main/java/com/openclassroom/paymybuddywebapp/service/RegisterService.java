package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import com.openclassroom.paymybuddywebapp.repository.RegisterProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterProxy registerProxy ;

    public Utilisateur saveUser(Utilisateur utilisateur){
        Utilisateur savedUser ;
        savedUser = registerProxy.createUser(utilisateur);
        return savedUser ;
    }

}
