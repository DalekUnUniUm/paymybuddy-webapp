package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.repository.GenericRequestProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenericRequestService {

    @Autowired
    private GenericRequestProxy genericRequestProxy ;

    public String userExist(String mail){
        return genericRequestProxy.userExist(mail);
    }
}
