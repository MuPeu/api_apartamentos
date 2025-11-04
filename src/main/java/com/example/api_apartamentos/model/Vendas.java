package com.example.api_apartamentos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_venda")

public class Vendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venda;

    @ManyToOne
    @JoinColumn(name = "id_ap", nullable = false)
    private Apartamentos id_ap;

    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = false)
    private Compradores id_compra;

    public Vendas(){

    }

    public Vendas(Integer id_venda, Apartamentos id_ap, Compradores id_compra){
        this.id_venda=id_venda;
        this.id_ap=id_ap;
        this.id_compra=id_compra;
    }

    @JsonProperty("id_venda") public Integer getId() { return id_venda; }
    @JsonProperty("id_venda") public void setId(Integer id_venda) { this.id_venda = id_venda; }

    public Apartamentos getAp() { return id_ap; }
    public void setAp(Apartamentos id_ap) { this.id_ap = id_ap; }

    public Compradores getForn() { return id_compra; }
    public void setForn(Compradores id_compra) { this.id_compra = id_compra; }
}
