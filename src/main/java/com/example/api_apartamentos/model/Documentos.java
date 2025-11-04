package com.example.api_apartamentos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_documentos")
public class Documentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_doc;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String numero;

    public Documentos() {}

    public Documentos(Integer id_doc, String tipo, String numero) {
        this.id_doc=id_doc;
        this.tipo=tipo;
        this.numero=numero;
    }

    public Integer getIdDocumento() { return id_doc; }
    public void setIdDocumento(Integer id_doc) { this.id_doc = id_doc; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
}
