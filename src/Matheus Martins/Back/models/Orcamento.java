package com.automech.automech.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orcamento")
public class Orcamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorcamento")
    private Integer idorcamento;

    @Column(name = "probelmasorcamento", nullable = false,length =500)
    private String probelmasorcamento;
    
    @ManyToOne
    @JoinColumn(name = "veiculo_idveiculo", nullable = false)
    private Veiculo veiculo;

    @Column(name = "statusorcamento")
    private int statusorcamento;

    @Column(name = "valororcamento")
    private double valororcamento;

    public Integer getIdorcamento() {
        return this.idorcamento;
    }

    public void setIdorcamento(Integer idorcamento) {
        this.idorcamento = idorcamento;
    }

    public String getProbelmasorcamento() {
        return this.probelmasorcamento;
    }

    public void setProbelmasorcamento(String probelmasorcamento) {
        this.probelmasorcamento = probelmasorcamento;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getStatusorcamento() {
        return this.statusorcamento;
    }

    public void setStatusorcamento(int statusorcamento) {
        this.statusorcamento = statusorcamento;
    }

    public double getValororcamento() {
        return this.valororcamento;
    }

    public void setValororcamento(double valororcamento) {
        this.valororcamento = valororcamento;
    }

}
