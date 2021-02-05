package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class RegisterProxy {

    @Autowired
    private CustomProperties customProperties ;


    public Utilisateur createUser(Utilisateur u){
        String createUserUrl = customProperties.getApiUrl()+"/utilisateur/register" ;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Utilisateur> request = new HttpEntity<Utilisateur>(u);
        ResponseEntity<Utilisateur> response = restTemplate.exchange(
                createUserUrl,
                HttpMethod.POST,
                request,
                Utilisateur.class
        );

        return response.getBody();
    }

}
