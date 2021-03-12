package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.HistoriqueTransaction;
import com.openclassroom.paymybuddywebapp.model.Utilisateur;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class HistoriqueTransactionProxy {

    @Autowired
    private CustomProperties customProperties ;

    public HistoriqueTransaction createTransaction(HistoriqueTransaction h){
        String createHistoriqueUrl = customProperties.getApiUrl()+"/historique" ;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<HistoriqueTransaction> request = new HttpEntity<HistoriqueTransaction>(h);
        ResponseEntity<HistoriqueTransaction> response = restTemplate.exchange(
                createHistoriqueUrl,
                HttpMethod.POST,
                request,
                HistoriqueTransaction.class
        );

        return request.getBody() ;
    }

    public JSONArray myHistoriqueId(int utilisateurId){
        String url = customProperties.getApiUrl() + "/historique/myHistorique?utilisateur_id=" + utilisateurId ;
        RestTemplate restTemplate = new RestTemplate();
        JSONArray reponse = restTemplate.getForObject(url, JSONArray.class);
        return reponse ;
    }

    public Iterable<HistoriqueTransaction>  getHistoriques(JSONArray ids){
        String getHistoriquesUrl = customProperties.getApiUrl()+"/historiques?ids=" ;

        String urlFinal = "" ;

        for(int i = 0 ; i < ids.size() ; i++){
            urlFinal += ids.get(i).toString() + ",";
        }
        getHistoriquesUrl += urlFinal;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<HistoriqueTransaction>> responseEntity = restTemplate.exchange(
                getHistoriquesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<HistoriqueTransaction>>() {}
        );

        return responseEntity.getBody();
    }
}
