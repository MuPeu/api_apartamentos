package com.example.api_apartamentos.service;

import com.example.api_apartamentos.model.*;
import com.example.api_apartamentos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImobiliariaService {

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    public List<Apartamentos> listarApartamentos() {
        return apartamentoRepository.findAll();
    }

    public Optional<Apartamentos> buscarApartamento(Integer id_ap) {
        return apartamentoRepository.findById(id_ap);
    }

    public Apartamentos cadastrarApartamento(Apartamentos apartamento) {
        apartamento.setDisponivel(true);
        return apartamentoRepository.save(apartamento);
    }

    public Apartamentos atualizarApartamento(Integer id_ap, Apartamentos atualizado) {
        return apartamentoRepository.findById(id_ap)
                .map(ap -> {
                    ap.setEndereco(atualizado.getEndereco());
                    ap.setNumQuartos(atualizado.getNumQuartos());
                    ap.setArea(atualizado.getArea());
                    ap.setPreco(atualizado.getPreco());
                    ap.setDisponivel(atualizado.isDisponivel());
                    return apartamentoRepository.save(ap);
                })
                .orElseThrow(() -> new RuntimeException("Apartamento não encontrado"));
    }

    public boolean deletarApartamento(Integer id_ap) {
        if (apartamentoRepository.existsById(id_ap)) {
            apartamentoRepository.deleteById(id_ap);
            return true;
        }
        return false;
    }

    public List<Compradores> listarCompradores() {
        return compradorRepository.findAll();
    }

    public Optional<Compradores> buscarComprador(Integer id_compra) {
        return compradorRepository.findById(id_compra);
    }

    public Compradores cadastrarComprador(Compradores comprador) {
        Documentos doc = documentoRepository.save(comprador.getDocumento());
        comprador.setDocumento(doc);
        return compradorRepository.save(comprador);
    }

    public boolean deletarComprador(Integer id_compra) {
        if (compradorRepository.existsById(id_compra)) {
            compradorRepository.deleteById(id_compra);
            return true;
        }
        return false;
    }

    public List<Vendas> listarVendas() {
        return vendaRepository.findAll();
    }

    public Vendas registrarVenda(Integer id_compra, Integer id_ap) {
        Compradores comprador = compradorRepository.findById(id_compra)
                .orElseThrow(() -> new RuntimeException("Comprador não encontrado"));

        Apartamentos apartamento = apartamentoRepository.findById(id_ap)
                .orElseThrow(() -> new RuntimeException("Apartamento não encontrado"));

        if (!apartamento.isDisponivel()) {
            throw new RuntimeException("Apartamento indisponível para venda");
        }

        apartamento.setDisponivel(false);
        apartamentoRepository.save(apartamento);

        Vendas venda = new Vendas(comprador, apartamento);
        return vendaRepository.save(venda);
    }
}
