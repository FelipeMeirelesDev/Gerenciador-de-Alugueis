package com.felipemeireles.gerenciamentoalugueis.services;

import com.felipemeireles.gerenciamentoalugueis.model.Inquilino;
import com.felipemeireles.gerenciamentoalugueis.repository.ImovelRepository;
import com.felipemeireles.gerenciamentoalugueis.repository.InquilinoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class InquilinoServices {

    private final InquilinoRepository repository;

    // Injeção via construtor (melhor prática)
    public InquilinoServices(InquilinoRepository repository) {
        this.repository = repository;
    }

    public Inquilino salvarInquilino(Inquilino inquilino){
        return repository.save(inquilino);
    }

    public List<Inquilino> listarInquilinos(){
        return repository.findAll();
    }

    public Inquilino buscarInquilino(Long id){
        return repository.findById(id).orElse(null);
    }

    public Inquilino atualizarInquilino(Inquilino inquilino){
        return repository.save(inquilino);
    }

    public void deletarInquilino(Long id){
        repository.deleteById(id);
    }
}
