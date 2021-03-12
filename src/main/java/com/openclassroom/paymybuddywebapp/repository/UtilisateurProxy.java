package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class UtilisateurProxy {
    @Autowired
    private CustomProperties customProperties ;

    public String userExist(String mail){
        String url = customProperties.getApiUrl() + "/utilisateur?mail=" + mail ;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url,String.class);
        return reponse ;
    }

    public String login(String mail, String password){
        String urlLogin = customProperties.getApiUrl() +"/utilisateur/login?mail="+mail+"&password="+password ;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(urlLogin,String.class);
        return reponse ;
    }

    public Utilisateur createUser(Utilisateur u){
        String createUserUrl = customProperties.getApiUrl()+"/utilisateur/register" ;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Utilisateur> request = new HttpEntity<Utilisateur>(u);
        ResponseEntity<Utilisateur> response = restTemplate.exchange(
                createUserUrl,
                HttpMethod.POST,
                request,
                Utilisateur.class
        );

        return response.getBody();
    }

    public Utilisateur getUtilisateur(int id){

        String getUtilisateurUrl = customProperties.getApiUrl()+"/utilisateur/"+id ;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Utilisateur> responseEntity = restTemplate.exchange(
                getUtilisateurUrl,
                HttpMethod.GET,
                null,
                Utilisateur.class
        );

        return responseEntity.getBody();
    }

    public String firstNameByUserId(String utilisateurId){
        String url = customProperties.getApiUrl() +"/utilisateur/firstNameById?utilisateurId="+utilisateurId;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url,String.class);
        return reponse ;
    }

    public String utilisateurIdByName(String firstName){
        String url = customProperties.getApiUrl() + "/utilisateurIdByName?firstName=" + firstName ;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url, String.class);

        return reponse ;
    }

    public int soldesIdByUserId(int utilisateurId){
        String url = customProperties.getApiUrl() + "/utilisateur/soldesIdById?utilisateurId="+utilisateurId;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url, String.class);

        return Integer.valueOf(reponse);
    }

    public String idByEmail(String email){
        String url = customProperties.getApiUrl() + "/utilisateur?mail="+email ;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url,String.class);

        return reponse ;
    }


}
