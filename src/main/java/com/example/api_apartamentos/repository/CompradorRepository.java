package com.example.api_apartamentos.repository;

import com.example.api_apartamentos.model.Compradores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompradorRepository extends JpaRepository<Compradores, Integer> {
}
