package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.model.Contact;
import com.openclassroom.paymybuddywebapp.repository.ContactProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactProxy contactProxy ;

    public Contact createContact(Contact contact){
        Contact savedContact ;
        savedContact = contactProxy.createContact(contact);
        return savedContact ;
    }

}
