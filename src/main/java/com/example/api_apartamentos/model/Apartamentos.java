package com.example.api_apartamentos.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_apartamento")

public class Apartamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ap;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Integer num_quartos;

    @Column(nullable = false)
    private Integer area;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private String disp;

    public Apartamentos(){

    }

    public Apartamentos(Integer id_ap, String endereco, Integer num_quartos, Integer area, Double preco, String disp) {
        this.id_ap = id_ap;
        this.endereco = endereco;
        this.num_quartos = num_quartos;
        this.area = area;
        this.preco = preco;
        this.disp = disp;
    }

    @JsonProperty("id_ap") public Integer getId() { return id_ap; }
    @JsonProperty("id_ap") public void setId(Integer id_ap) { this.id_ap = id_ap; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public Integer getNum_quartos() { return num_quartos; }
    public void setNum_quartos(Integer num_quartos) { this.num_quartos = num_quartos; }

    public Integer getArea() { return area; }
    public void setArea(Integer area) { this.area = area; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public String getDisp() { return disp; }
    public void setDisp(String disp) { this.disp = disp; }
}
