package org.example;

import java.util.Objects;

public class Cardapio {
    private String nomeSobremesa;
    private double precoSobremesa;
    private String nomeSalgado;
    private double precoSalgado;
    private String nomeBebida;
    private double precoBebida;

    public String getNomeSobremesa() {
        return nomeSobremesa;
    }

    public void setNomeSobremesa(String nomeSobremesa) {
        this.nomeSobremesa = nomeSobremesa;
    }

    public double getPrecoSobremesa() {
        return precoSobremesa;
    }

    public void setPrecoSobremesa(double precoSobremesa) {
        this.precoSobremesa = precoSobremesa;
    }

    public String getNomeSalgado() {
        return nomeSalgado;
    }

    public void setNomeSalgado(String nomeSalgado) {
        this.nomeSalgado = nomeSalgado;
    }

    public double getPrecoSalgado() {
        return precoSalgado;
    }

    public void setPrecoSalgado(double precoSalgado) {
        this.precoSalgado = precoSalgado;
    }

    public String getNomeBebida() {
        return nomeBebida;
    }

    public void setNomeBebida(String nomeBebida) {
        this.nomeBebida = nomeBebida;
    }

    public double getPrecoBebida() {
        return precoBebida;
    }

    public void setPrecoBebida(double precoBebida) {
        this.precoBebida = precoBebida;
    }

    public Cardapio(String nomeSobremesa,double precoSobremesa) {
        this.nomeSobremesa = nomeSobremesa;
        this.precoSobremesa = precoSobremesa;
    }

    @Override
    public String toString() {
        return "Cardapio{" +
                "nomeSobremesa='" + nomeSobremesa + '\'' +
                ", precoSobremesa=" + precoSobremesa +
                ", nomeSalgado='" + nomeSalgado + '\'' +
                ", precoSalgado=" + precoSalgado +
                ", nomeBebida='" + nomeBebida + '\'' +
                ", precoBebida=" + precoBebida +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cardapio cardapio = (Cardapio) o;
        return Double.compare(precoSobremesa, cardapio.precoSobremesa) == 0 && Double.compare(precoSalgado, cardapio.precoSalgado) == 0 && Double.compare(precoBebida, cardapio.precoBebida) == 0 && Objects.equals(nomeSobremesa, cardapio.nomeSobremesa) && Objects.equals(nomeSalgado, cardapio.nomeSalgado) && Objects.equals(nomeBebida, cardapio.nomeBebida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeSobremesa, precoSobremesa, nomeSalgado, precoSalgado, nomeBebida, precoBebida);
    }
}