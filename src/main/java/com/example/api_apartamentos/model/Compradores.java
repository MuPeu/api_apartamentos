package com.example.api_apartamentos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_compradores")

public class Compradores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_compra;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String CPF;

    @Column(nullable = false)
    private String tele;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cidade;

    public Compradores(){

    }

    public Compradores(Integer id_compra, String nome, String CPF, String tele, String email, String cidade){
        this.id_compra=id_compra;
        this.nome=nome;
        this.CPF=CPF;
        this.tele=tele;
        this.email=email;
        this.cidade=cidade;
    }

    @JsonProperty("id_compra") public Integer getId() { return id_compra; }
    @JsonProperty("id_compra") public void setId(Integer id_compra) { this.id_compra = id_compra; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCPF() { return CPF; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    public String getTele() { return tele; }
    public void setTele(String tele) { this.tele = tele; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
}
