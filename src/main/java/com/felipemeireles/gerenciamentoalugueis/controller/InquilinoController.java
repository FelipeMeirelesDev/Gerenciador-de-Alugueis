package com.felipemeireles.gerenciamentoalugueis.controller;

import com.felipemeireles.gerenciamentoalugueis.model.Inquilino;
import com.felipemeireles.gerenciamentoalugueis.services.ImovelServices;
import com.felipemeireles.gerenciamentoalugueis.services.InquilinoServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inquilinos")
public class InquilinoController {

    InquilinoServices services;

    public InquilinoController(InquilinoServices services) {
        this.services = services;
    }

    @GetMapping
    public List<Inquilino> listarInquilinos(){
        return services.listarInquilinos();
    }

    @GetMapping("/{id}")
    public Inquilino buscarInquilino(@PathVariable Long id){
        return services.buscarInquilino(id);
    }

    @PostMapping()
    public Inquilino salvarInquilino(@RequestBody Inquilino inquilino){
        return services.salvarInquilino(inquilino);
    }

    @PutMapping
    public Inquilino atualizarInquilino(Long id, Inquilino inquilino){
        inquilino.setId(id);
        return services.atualizarInquilino(inquilino);
    }

    @DeleteMapping("/{id}")
    public void deletarInquilino(@PathVariable Long id){
        services.deletarInquilino(id);
    }
}
