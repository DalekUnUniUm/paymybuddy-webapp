package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class LoginProxy {

    @Autowired
    private CustomProperties customProperties ;


    public String login(String mail, String password){
        String urlLogin = customProperties.getApiUrl() +"/utilisateur/login?mail="+mail+"&password="+password ;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(urlLogin,String.class);
        return reponse ;
    }

}
