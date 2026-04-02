package com.felipemeireles.gerenciamentoalugueis.controller;

import com.felipemeireles.gerenciamentoalugueis.model.Imovel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pagina")
public class PaginaController {

    @RequestMapping("/inicio")
    public String index(){
        return "index";
    }

    @RequestMapping("/imovel")
    public String pagina_imoveis(Model model) {
        return "imoveis";
    }
}