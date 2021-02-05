package com.openclassroom.paymybuddywebapp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "com.openclassroom.paymybuddywebapp")
public class CustomProperties {
    private String apiUrl ;

    public String getApiUrl() {
        return apiUrl;
    }
}
