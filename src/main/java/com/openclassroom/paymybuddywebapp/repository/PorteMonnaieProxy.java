package com.openclassroom.paymybuddywebapp.repository;

import com.openclassroom.paymybuddywebapp.CustomProperties;
import com.openclassroom.paymybuddywebapp.model.PorteMonnaie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PorteMonnaieProxy {
    @Autowired
    private CustomProperties customProperties ;

    private RestTemplate restTemplate ;
    private String reponse ;

    public PorteMonnaie createPorteMonnaie(PorteMonnaie p){
        String createPorteMonnaieUrl = customProperties.getApiUrl()+"/wallet" ;

        restTemplate = new RestTemplate();
        HttpEntity<PorteMonnaie> request = new HttpEntity<PorteMonnaie>(p) ;
        ResponseEntity<PorteMonnaie> response = restTemplate.exchange(
                createPorteMonnaieUrl,
                HttpMethod.POST,
                request,
                PorteMonnaie.class
        );

        return response.getBody();
    }
    public String getBankAccount(int utilisateurSoldesId){
        String getBankAccUrl = customProperties.getApiUrl() + "/wallet/getBankAccount?soldesId="+utilisateurSoldesId ;
        restTemplate = new RestTemplate();
        reponse = restTemplate.getForObject(getBankAccUrl, String.class);
        return reponse ;
    }

    public void updateBankAccount(String bankAccount, int utilisateurSoldesId){
        String addSoldeUrl = customProperties.getApiUrl() + "/wallet/bankaccount?bankaccount="+bankAccount+"&soldesId="+utilisateurSoldesId ;
        restTemplate = new RestTemplate();
        restTemplate.put(addSoldeUrl, String.class);
    }
    public String mySolde(int utilisateurId){

        String getMySoldeUrl = customProperties.getApiUrl() + "/wallet/soldes?soldesId=" + utilisateurId ;
        restTemplate = new RestTemplate();
        reponse = restTemplate.getForObject(getMySoldeUrl, String.class);

        return reponse ;
    }

    public void addSoldes(int sommes, int utilisateurSoldesId){
        String addSoldeUrl = customProperties.getApiUrl() + "/wallet/updateSoldesAdd?addSoldes="+sommes+"&soldesId="+utilisateurSoldesId ;
        restTemplate = new RestTemplate();
        restTemplate.put(addSoldeUrl, String.class);
    }

    public void soustractSoldes(int sommes, int utilisateurSoldesId){
        String soustractSoldeUrl = customProperties.getApiUrl() + "/wallet/updateSoldesSoustract?soustractSoldes="+sommes+"&soldesId="+utilisateurSoldesId ;
        restTemplate = new RestTemplate();
        restTemplate.put(soustractSoldeUrl, String.class);
    }
}
