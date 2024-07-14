package com.fabio.app.gaseta.model;

public class Combustivel {

    private String nomeDoCombustivel;
    private Double precoDoCombustivel;
    private String recomendado;

    public String getNomeDoCombustivel() {
        return nomeDoCombustivel;
    }

    public void setNomeDoCombustivel(String nomeDoCombustivel) {
        this.nomeDoCombustivel = nomeDoCombustivel;
    }

    public Double getPrecoDoCombustivel() {
        return precoDoCombustivel;
    }

    public void setPrecoDoCombustivel(Double precoDoCombustivel) {
        this.precoDoCombustivel = precoDoCombustivel;
    }

    public String getRecomendado() {
        return recomendado;
    }

    public void setRecomendado(String recomendado) {
        this.recomendado = recomendado;
    }
}