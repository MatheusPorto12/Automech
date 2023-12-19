package com.horou.Tis.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "oficinas_avaliacoes")

public class Avaliacao {
@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="idavaliacao" )
    private Integer idavaliacao;

    @Column(name = "idcliente")
    private Integer idcliente;

    @Column(name = "textoavaliacao")
    private String textoavaliacao;

    @Column(name = "notaavaliacao")
    private int notaavaliacao;

    @Column(name = "oficinas_idoficinas")
    private Integer oficinas_idoficinas;




    public Integer getIdavaliacao() {
        return this.idavaliacao;
    }

    public void setIdavaliacao(Integer idavaliacao) {
        this.idavaliacao = idavaliacao;
    }

    public Integer getIdcliente() {
        return this.idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getTextoavaliacao() {
        return this.textoavaliacao;
    }

    public void setTextoavaliacao(String textoavaliacao) {
        this.textoavaliacao = textoavaliacao;
    }

    public int getNotaavaliacao() {
        return this.notaavaliacao;
    }

    public void setNotaavaliacao(int notaavaliacao) {
        this.notaavaliacao = notaavaliacao;
    }

    public Integer getOficinas_idoficinas() {
        return this.oficinas_idoficinas;
    }

    public void setOficinas_idoficinas(Integer oficinas_idoficinas) {
        this.oficinas_idoficinas = oficinas_idoficinas;
    }
   
}
