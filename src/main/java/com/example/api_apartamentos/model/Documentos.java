package com.example.api_apartamentos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Documento {
    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String numero;

    public Documento() {}

    public Documento(String tipo, String numero) {
        this.tipo=tipo;
        this.numero=numero;
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
}
