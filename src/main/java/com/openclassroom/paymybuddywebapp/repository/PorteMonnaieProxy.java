package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.PorteMonnaie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PorteMonnaieProxy {
    @Autowired
    private CustomProperties customProperties ;

    public PorteMonnaie createPorteMonnaie(PorteMonnaie p){
        String createPorteMonnaieUrl = customProperties.getApiUrl()+"/wallet" ;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PorteMonnaie> request = new HttpEntity<PorteMonnaie>(p) ;
        ResponseEntity<PorteMonnaie> response = restTemplate.exchange(
                createPorteMonnaieUrl,
                HttpMethod.POST,
                request,
                PorteMonnaie.class
        );

        return response.getBody();
    }
}
