package com.openclassroom.paymybuddywebapp.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Contact {

    private String firstName ;

    private String email ;

    private String problem ;
}
