package com.fabio.app.gaseta.model;

public class Combustivel {

    private String nomeDoCombustivel;
    private Double precoDoCombustivel;
    private String recomendacao;

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

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }
}
