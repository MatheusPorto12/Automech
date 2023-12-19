package com.mathias.tis.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Oficina.TABLE_NAME)
public class Oficina {

    public static final String TABLE_NAME = "oficinas";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoficinas", unique = true)
    private Integer idoficinas;

    @Column(name = "cnpj", unique = true, nullable = false)
    private String cnpj;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "qtdfuncionarios")
    private Integer qtdfuncionarios;

    @Column(name = "telefone", length = 45, nullable = false)
    private String telefone;

    @Column(name = "email", length = 45, nullable = false, unique = true)
    private String email;

    @Column(name = "temsite", nullable = false)
    private Integer temsite;

    @Column(name = "endereco", length = 200, nullable = false)
    private String endereco;

       @Column(name = "descricao", length = 800, nullable = false)
    private String descricao;


    public Integer getId() {
        return this.idoficinas;
    }

    public void setId(Integer idoficinas) {
        this.idoficinas = idoficinas;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdfuncionarios() {
        return this.qtdfuncionarios;
    }

    public void setQtdfuncionarios(Integer qtdfuncionarios) {
        this.qtdfuncionarios = qtdfuncionarios;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTemsite() {
        return this.temsite;
    }

    public void setTemsite(Integer temsite) {
        this.temsite = temsite;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
