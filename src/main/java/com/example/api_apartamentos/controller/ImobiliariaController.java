package com.example.api_apartamentos.controller;

import com.example.api_apartamentos.model.*;
import com.example.api_apartamentos.service.ImobiliariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imobiliaria")
public class ImobiliariaController {

    @Autowired
    private ImobiliariaService service;

    @GetMapping("/apartamentos")
    public ResponseEntity<List<Apartamentos>> listarApartamentos() {
        return ResponseEntity.ok(service.listarApartamentos());
    }

    @GetMapping("/apartamentos/{id_ap}")
    public ResponseEntity<Apartamentos> buscarApartamento(@PathVariable Integer id_ap) {
        return service.buscarApartamento(id_ap)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/apartamentos")
    public ResponseEntity<Apartamentos> cadastrarApartamento(@RequestBody Apartamentos apartamento) {
        Apartamentos novo = service.cadastrarApartamento(apartamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @PutMapping("/apartamentos/{id_ap}")
    public ResponseEntity<Apartamentos> atualizarApartamento(@PathVariable Integer id_ap, @RequestBody Apartamentos atualizado) {
        Apartamentos ap = service.atualizarApartamento(id_ap, atualizado);
        return ResponseEntity.ok(ap);
    }

    @DeleteMapping("/apartamentos/{id_ap}")
    public ResponseEntity<Void> deletarApartamento(@PathVariable Integer id_ap) {
        return service.deletarApartamento(id_ap)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/compradores")
    public ResponseEntity<List<Compradores>> listarCompradores() {
        return ResponseEntity.ok(service.listarCompradores());
    }

    @GetMapping("/compradores/{id_compra}")
    public ResponseEntity<Compradores> buscarComprador(@PathVariable Integer id_compra) {
        return service.buscarComprador(id_compra)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/compradores")
    public ResponseEntity<Compradores> cadastrarComprador(@RequestBody Compradores comprador) {
        Compradores novo = service.cadastrarComprador(comprador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @DeleteMapping("/compradores/{id_compra}")
    public ResponseEntity<Void> deletarComprador(@PathVariable Integer id_compra) {
        return service.deletarComprador(id_compra)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/vendas")
    public ResponseEntity<List<Vendas>> listarVendas() {
        return ResponseEntity.ok(service.listarVendas());
    }

    @PostMapping("/vendas")
    public ResponseEntity<Vendas> registrarVenda(@RequestParam Integer id_compra, @RequestParam Integer id_ap) {
        Vendas novaVenda = service.registrarVenda(id_compra, id_ap);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVenda);
    }
}
