package com.soulcode.projetofinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.projetofinal.models.Financeiro;
import com.soulcode.projetofinal.repositories.FinanceiroRepository;

@Controller
public class FiltroController {
   
    @Autowired
    private FinanceiroRepository FinanceiroRepository;

     @GetMapping("/filtro")
    public ModelAndView paginaFinancas(){
        List<Financeiro> financas = FinanceiroRepository.findAll(); //Equivale a SELECT*FROM FINANCAS
        // Usamos ModelAndView quando precisamos fornecer dados para o HTML
        ModelAndView mv = new ModelAndView("filtro"); //// Indica qual o template/view
        // Nome da variável do template e o valor dessa variável
        mv.addObject("listaFinancas", financas); //Conecta com o HTML
        return mv; // Objeto configurado com a view e os dados que ela vai usar
    }
}