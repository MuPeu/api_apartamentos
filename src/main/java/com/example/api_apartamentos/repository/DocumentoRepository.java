package com.example.api_apartamentos.repository;

import com.example.api_apartamentos.model.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documentos, Integer> {
}
