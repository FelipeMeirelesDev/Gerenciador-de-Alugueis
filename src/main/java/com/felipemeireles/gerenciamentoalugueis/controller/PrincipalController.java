package com.felipemeireles.gerenciamentoalugueis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {

    @RequestMapping("/pagina_index")
    public String index(){
        return "index";
    }

    @RequestMapping("/pagina_imovel")
    public String pagina_imoveis(){
        return "imoveis";
    }
}