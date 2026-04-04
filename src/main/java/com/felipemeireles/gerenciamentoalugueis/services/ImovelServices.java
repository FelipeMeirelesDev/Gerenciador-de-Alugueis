package com.felipemeireles.gerenciamentoalugueis.services;

import com.felipemeireles.gerenciamentoalugueis.model.Imovel;
import com.felipemeireles.gerenciamentoalugueis.repository.ImovelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImovelServices {

    private final ImovelRepository repository; // <-- sempre private final

    // Injeção via construtor (melhor prática)
    public ImovelServices(ImovelRepository repository) {
        this.repository = repository;
    }

    public Imovel salvarImovel(Imovel imovel){
        return repository.save(imovel);
    }

    public List<Imovel> listarImoveis(){
        return repository.findAll();
    }

    public Imovel buscarImovel(Long id){
        return repository.findById(id).orElse(null);
    }

    public void deletarImovel (Long id){
        repository.deleteById(id);
    }

    public Imovel atualizarImovel (Imovel imovel){
        return repository.save(imovel);
    }
}