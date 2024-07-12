package com.fabio.app.gaseta.controller;

import com.fabio.app.gaseta.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List listaCursos;
    public List getListaCursos(){

        listaCursos = new ArrayList<Curso>();

        listaCursos.add(new Curso("java"));
        listaCursos.add(new Curso("javaScript"));
        listaCursos.add(new Curso("HXLM"));
        listaCursos.add(new Curso("PHP"));
        listaCursos.add(new Curso("Kotin"));
        listaCursos.add(new Curso("Android"));
        listaCursos.add(new Curso("fluter"));

        return listaCursos;
    }

    public ArrayList<String> dadosParaSpiner(){

        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCursos().size(); i++) {

            Curso objeto = (Curso) getListaCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());

        }
        return  dados;
    }


}
