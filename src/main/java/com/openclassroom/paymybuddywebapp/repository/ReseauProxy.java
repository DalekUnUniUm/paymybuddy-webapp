package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.Reseau;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ReseauProxy {

    @Autowired
    private CustomProperties customProperties ;

    public Reseau createUser(Reseau r){
        String createUserUrl = customProperties.getApiUrl()+"/reseau" ;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Reseau> request = new HttpEntity<Reseau>(r);
        ResponseEntity<Reseau> response = restTemplate.exchange(
                createUserUrl,
                HttpMethod.POST,
                request,
                Reseau.class
        );

        return response.getBody();
    }

    public JSONObject listFriendId(int utilisateurId){

        String url = customProperties.getApiUrl() + "/reseau/listFriendsFirstName?utilisateur_id=" + utilisateurId ;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject reponse = restTemplate.getForObject(url, JSONObject.class);

        return reponse ;
    }

    public int isFriend(int userId , int userFriendId){
        String url = customProperties.getApiUrl() + "reseau/isFriends?userAId="+userId+"&userBId="+userFriendId ;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url, String.class);

        return Integer.valueOf(reponse) ;
    }


    public int soldesIdByUserId(int utilisateurId){
        String url = customProperties.getApiUrl() + "/utilisateur/soldesIdById?utilisateurId="+utilisateurId;
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url, String.class);

        return Integer.valueOf(reponse);
    }

}
