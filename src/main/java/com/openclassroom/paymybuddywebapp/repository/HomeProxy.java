package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class HomeProxy {

    @Autowired
    private CustomProperties customProperties ;

    public Utilisateur getUtilisateur(int id){

        String getUtilisateurUrl = customProperties.getApiUrl()+"/utilisateur/"+id ;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Utilisateur> responseEntity = restTemplate.exchange(
                getUtilisateurUrl,
                HttpMethod.GET,
                null,
                Utilisateur.class
        );

        return responseEntity.getBody();
    }
}
