package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ContactProxy {

    @Autowired
    private CustomProperties customProperties ;


    public Contact createContact(Contact c){
        String createUrl = customProperties.getApiUrl()+"/contact" ;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Contact> request = new HttpEntity<Contact>(c);
        ResponseEntity<Contact> response = restTemplate.exchange(
                createUrl,
                HttpMethod.POST,
                request,
                Contact.class
        );

        return response.getBody();
    }

}
