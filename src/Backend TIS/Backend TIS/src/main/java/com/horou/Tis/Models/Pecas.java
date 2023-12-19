package com.horou.Tis.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pecas")
public class Pecas {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="idpeca" )
    private Integer idpeca;

    @Column(name = "tipopeca", length = 45)
    private String tipopeca;

    @Column(name = "valorpeca")
    private double valorpeca;

    @Column(name = "descricaopeca")
    private String descricaopeca;

    @Column(name = "quantidadepecas")
    private int quantidadepecas;

    public Integer getIdpeca() {
        return this.idpeca;
    }

    public void setIdpeca(Integer idpeca) {
        this.idpeca = idpeca;
    }

    public String getTipopeca() {
        return this.tipopeca;
    }

    public void setTipopeca(String tipopeca) {
        this.tipopeca = tipopeca;
    }

    public double getValorpeca() {
        return this.valorpeca;
    }

    public void setValorpeca(double valorpeca) {
        this.valorpeca = valorpeca;
    }

    public String getDescricaopeca() {
        return this.descricaopeca;
    }

    public int getQuantidadepecas() {
        return this.quantidadepecas;
    }
    public void setQuantidadepecas(int quantidadepecas) {
        this.quantidadepecas = quantidadepecas;
    }


    public void setDescricaopeca(String descricaopeca) {
        this.descricaopeca = descricaopeca;
    }



    
}
