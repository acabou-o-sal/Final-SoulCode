package com.soulcode.projetofinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinancasController {
    @GetMapping("/financas")
    public String paginaFinancas(){
        return "financas";
    }
}
