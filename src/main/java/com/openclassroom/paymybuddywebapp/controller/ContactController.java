package com.openclassroom.paymybuddywebapp.controller;

import com.openclassroom.paymybuddywebapp.model.Contact;
import com.openclassroom.paymybuddywebapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService ;

    @Autowired
    private Contact contact ;

    @GetMapping("/contact")
    public String contact(Model model){
        contact = new Contact();
        model.addAttribute("contact",contact);
        return "contact" ;
    }

    @PostMapping("/contact")
    public ModelAndView saveContact(@ModelAttribute Contact contact){
        contactService.createContact(contact);
        return new ModelAndView("redirect:/contact");
    }

}