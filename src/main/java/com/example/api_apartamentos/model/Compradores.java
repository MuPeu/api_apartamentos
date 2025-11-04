package com.example.api_apartamentos.model;

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
    private String telefone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_documento", nullable = false)
    private Documentos documento;

    public Compradores() {}

    public Compradores(Integer id_compra, String nome, String telefone, String email, String cidade, Documentos documento) {
        this.nome=nome;
        this.telefone=telefone;
        this.email=email;
        this.cidade=cidade;
        this.documento=documento;
    }

    public Integer getIdComprador() { return id_compra; }
    public void setIdComprador(Integer id_compra) { this.id_compra = id_compra; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public Documentos getDocumento() { return documento; }
    public void setDocumento(Documentos documento) { this.documento = documento; }
}