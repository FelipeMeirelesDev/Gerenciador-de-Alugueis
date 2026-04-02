package com.felipemeireles.gerenciamentoalugueis.controller;

import com.felipemeireles.gerenciamentoalugueis.model.Imovel;
import com.felipemeireles.gerenciamentoalugueis.services.ImovelServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imoveis")
public class ImovelController {

    ImovelServices services;

    public ImovelController(ImovelServices services) {
        this.services = services;
    }

    @GetMapping("/{id}")
    public Imovel buscarImovel(@PathVariable Long id){
        return services.buscarImovel(id);
    }

    @GetMapping
    public List<Imovel> listarImoveis(){
        return services.listarImoveis();
    }

    @PostMapping
    public void salvarImovel(@RequestBody Imovel imovel){
        services.salvarImovel(imovel);
    }

    @DeleteMapping("/{id}")
    public void deletarImovel(@PathVariable Long id){
        services.deletarImovel(id);
    }


}
