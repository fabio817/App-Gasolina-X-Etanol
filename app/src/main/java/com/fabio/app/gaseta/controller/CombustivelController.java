package com.fabio.app.gaseta.controller;

import android.content.SharedPreferences;

import com.fabio.app.gaseta.model.Combustivel;
import com.fabio.app.gaseta.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreferences;

    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity activity){

        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel){
        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        //dadosPreferences.putFloat("precoDocombustivel", combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("recomendacao", combustivel.getRecomendado());
        dadosPreferences.apply();
    }


}
