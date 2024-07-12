package com.fabio.app.gaseta.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.fabio.app.gaseta.model.Pessoa;
import com.fabio.app.gaseta.view.MainActivity;

public class PessoaController {
    SharedPreferences preferences;
    SharedPreferences.Editor listavip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public PessoaController(MainActivity activity) {
        preferences =
                activity.getSharedPreferences(NOME_PREFERENCES, 0);
        listavip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC_Controller", "salvar: " + pessoa.toString());

        listavip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listavip.putString("sobreNome", pessoa.getSobreNome());
        listavip.putString("cursoDesejado", pessoa.getCursoDesejado());
        listavip.putString("telefoneContato", pessoa.getTelefoneContato());
        listavip.apply();
    }

    public Pessoa buscar(Pessoa pessoa) {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobreNome", ""));
        pessoa.setCursoDesejado(preferences.getString("cursoDesejado", ""));
        pessoa.setTelefoneContato(preferences.getString("telefoneContato", ""));

        return pessoa;
    }

    public void limpar() {
        listavip.clear();
        listavip.apply();
    }

}
