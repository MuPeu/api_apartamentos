package com.example.api_apartamentos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_vendas")
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venda;

    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = false)
    private Compradores comprador;

    @OneToOne
    @JoinColumn(name = "id_ap", nullable = false)
    private Apartamentos apartamento;

    @Column(nullable = false)
    private LocalDate dataVenda;

    public Vendas() {

    }

    public Vendas(Compradores comprador, Apartamentos apartamento) {
        this.comprador=comprador;
        this.apartamento=apartamento;
        this.dataVenda=LocalDate.now();
    }

    public Integer getIdVenda() { return id_venda; }
    public void setIdVenda(Integer id_venda) { this.id_venda = id_venda; }

    public Compradores getComprador() { return comprador; }
    public void setComprador(Compradores comprador) { this.comprador = comprador; }

    public Apartamentos getApartamento() { return apartamento; }
    public void setApartamento(Apartamentos apartamento) { this.apartamento = apartamento; }

    public LocalDate getDataVenda() { return dataVenda; }
    public void setDataVenda(LocalDate dataVenda) { this.dataVenda = dataVenda; }
}