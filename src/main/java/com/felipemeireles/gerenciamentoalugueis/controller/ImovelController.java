package com.felipemeireles.gerenciamentoalugueis.controller;

import com.felipemeireles.gerenciamentoalugueis.model.Imovel;
import com.felipemeireles.gerenciamentoalugueis.services.ImovelServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/imovel")
public class ImovelController {

    ImovelServices services;

    @GetMapping("/{id}")
    public Imovel buscarImovel(@PathVariable Long id){
        return services.buscarImovel(id);
    }

    @GetMapping
    public List<Imovel> listarImoveis(){
        return services.listarImoveis();
    }

    @PostMapping
    public void salvarImovel(Imovel imovel){
        services.salvarImovel(imovel);
    }

    @DeleteMapping("/{id}")
    public void deletarImovel(@PathVariable Long id){
        services.deletarImovel(id);
    }


}
