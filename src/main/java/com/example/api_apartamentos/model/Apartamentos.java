package com.example.api_apartamentos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_apartamentos")
public class Apartamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ap;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Integer numQuartos;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Boolean disponivel = true;

    public Apartamentos() {}

    public Apartamentos(Integer id_ap, String endereco, Integer numQuartos, Double area, BigDecimal preco) {
        this.id_ap=id_ap;
        this.endereco=endereco;
        this.numQuartos=numQuartos;
        this.area=area;
        this.preco=preco;
        this.disponivel=true;
    }

    public Integer getIdAp() { return id_ap; }
    public void setIdAp(Integer id_ap) { this.id_ap = id_ap; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Integer getNumQuartos() { return numQuartos; }
    public void setNumQuartos(Integer numQuartos) { this.numQuartos = numQuartos; }

    public Double getArea() { return area; }
    public void setArea(Double area) { this.area = area; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public Boolean isDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}