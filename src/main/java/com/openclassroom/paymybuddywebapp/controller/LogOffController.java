package com.openclassroom.paymybuddywebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LogOffController {

    @GetMapping("/logoff")
    public String logoff(HttpServletResponse response){

        Cookie cookie = new Cookie("utilisateurId",null);
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        return "logoff" ;
    }

}
