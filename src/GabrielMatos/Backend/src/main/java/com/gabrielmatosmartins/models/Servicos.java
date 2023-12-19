package com.gabrielmatosmartins.models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Servicos.TABLE_NAME)
public class Servicos {
private static final String TABLE_NAME="servicos";

@Id
@Column(name = "idServico")
private Integer id;

@Column(name = "valorServico")
private Double valor;

@Column(name = "statusServico")
private String statusServico;

@Column(name = "dataServico")
private Date dataServico;

@Column(name = "descricaoServico")
private String descricao;

@Column(name = "obsServico")
private String obs;

@Column(name = "prazoServico")
private Date prazoServico;

@Column(name = "dataHoraAtualizacao")
private Date atualizacao;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getstatusServico() {
        return this.statusServico;
    }

    public void setstatusServico(String statusServico) {
        this.statusServico = statusServico;
    }


    public Date getDataServico() {
        return this.dataServico;
    }

    public void setDataServico(Date dataServico) {
        this.dataServico = dataServico;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Date getPrazoServico() {
        return this.prazoServico;
    }

    public void setPrazoServico(Date prazoServico) {
        this.prazoServico = prazoServico;
    }

    public Date getAtualizacao() {
        return this.atualizacao;
    }

    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }

    public boolean hashCode(Object obj){
        if(obj==this)
        return true;
        if(obj==null)
        return false;
        if(!(obj instanceof Servicos))
        return false;

        Servicos other=(Servicos) obj;
        if(this.id==null)
           if(other.id!=null)
           return false;
           else if(!this.id.equals(other.id))
           return false;

           return Objects.equals(this.id, other.id)&& Objects.equals(this.valor, other.valor)
           && Objects.equals(this.obs, other.obs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, obs, valor, prazoServico);
    }

    public Object getCliente() {
        return null;
    }


}