package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class GenericRequestProxy {

    @Autowired
    private CustomProperties customProperties ;

    public String userExist(String mail){
        String url = customProperties.getApiUrl() + "/utilisateur?mail=" + mail ;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url,String.class);
        return reponse ;
    }

}
