package com.example.api_apartamentos.repository;

import com.example.api_apartamentos.model.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Vendas, Integer> {
}
