package com.openclassroom.paymybuddywebapp.service;

import com.openclassroom.paymybuddywebapp.model.HistoriqueTransaction;
import com.openclassroom.paymybuddywebapp.repository.HistoriqueTransactionProxy;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueTransactionService {

    @Autowired
    private HistoriqueTransactionProxy historiqueTransactionProxy;

    public HistoriqueTransaction saveHistorique(HistoriqueTransaction historiqueTransaction){
        HistoriqueTransaction savedHistorique ;
        savedHistorique = historiqueTransactionProxy.createTransaction(historiqueTransaction);
        return savedHistorique ;
    }

    public JSONArray myHistoriqueId(int utilisateurId) {
        return historiqueTransactionProxy.myHistoriqueId(utilisateurId);
    }

    public Iterable<HistoriqueTransaction> getHistoriques(JSONArray ids){
        return historiqueTransactionProxy.getHistoriques(ids);
    }

}
