package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.repository.LoginProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginProxy loginProxy ;

    public String login(String mail, String password){
        return loginProxy.login(mail,password);
    }

}
