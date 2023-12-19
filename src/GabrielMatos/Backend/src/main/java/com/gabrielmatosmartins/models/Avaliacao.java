package com.gabrielmatosmartins.models;

import jakarta.persistence.*;

@Entity
@Table(name = Avaliacao.TABLE_NAME)
public class Avaliacao {
    public static final String TABLE_NAME = "avaliacao";

    @Id
    @Column(name = "idAvaliacao")
    private Integer idAvaliacao;

    @Id
    @Column(name = "idCliente")
    private Integer idCliente;

    @Id
    @Column(name = "idoficina")
    private Integer idoficina;

    @Column(name = "textoAvaliacao", length = 100, nullable = false)
    private String textoAvaliacao;

    @Column(name = "notaAvaliacao")
    private int notaAvaliacao;

    public Avaliacao(){}

    public Avaliacao(Integer idAvaliacao, Integer idCliente, String textoAvaliacao, int notaAvaliacao, Integer idoficina){
        this.idAvaliacao = idAvaliacao;
        this.idCliente = idCliente;
        this.textoAvaliacao = textoAvaliacao;
        this.notaAvaliacao = notaAvaliacao;
        this.idoficina = idoficina;
    }

    public Integer getIdAvaliacao(){
        return this.idAvaliacao;
    }

    public String getTextoAvaliacao(){
        return this.textoAvaliacao;
    }

    public void setTextoAvaliacao(String textoAvaliacao){
        this.textoAvaliacao = textoAvaliacao;
    }

    public int getNotaAvaliacao(){
        return this.notaAvaliacao;
    }

    public void setNotaAvaliacao(int notaAvaliacao){
        this.notaAvaliacao = notaAvaliacao;
    }


    public void setIdAvaliacao(Integer idAvaliacao){
        this.idAvaliacao = idAvaliacao;
    }


}
