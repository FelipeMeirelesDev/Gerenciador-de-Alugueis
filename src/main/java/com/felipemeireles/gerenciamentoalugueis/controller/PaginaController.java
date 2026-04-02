package com.felipemeireles.gerenciamentoalugueis.controller;

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
    public String pagina_imovel(Model model) {
        return "imovel";
    }

    @RequestMapping("/inquilino")
    public String pagina_inquilino(Model model) {
        return "inquilino";
    }

    @RequestMapping("/contrato")
    public String pagina_contrato(Model model) {
        return "contrato";
    }

    @RequestMapping("/pagamento")
    public String pagina_pagamento(Model model) {
        return "pagamento";
    }

    @RequestMapping("/configuracao")
    public String pagina_configuracao(Model model) {
        return "configuracao";
    }

}