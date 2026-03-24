package com.felipemeireles.gerenciamentoalugueis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrincipalController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/imoveis")
    public String pagina_imoveis(){
        return "imoveis";
    }
}
