package com.soulcode.projetofinal.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.soulcode.projetofinal.models.Financeiro;
import com.soulcode.projetofinal.repositories.FiltroRepository;
import com.soulcode.projetofinal.repositories.FinanceiroRepository;

@Controller
public class FiltroController {
   
    @Autowired
    private FiltroRepository FiltroRepository;

     @GetMapping("/filtro")
    public ModelAndView paginaFinancas(){
        List<Financeiro> financas = FiltroRepository.findAll(); //Equivale a SELECT*FROM FINANCAS
        // Usamos ModelAndView quando precisamos fornecer dados para o HTML
        ModelAndView mv = new ModelAndView("filtro"); //// Indica qual o template/view
        // Nome da variável do template e o valor dessa variável
        mv.addObject("listaFinancas", financas); //Conecta com o HTML
        return mv; // Objeto configurado com a view e os dados que ela vai usar
    }

    @PostMapping("/filtrarPorCategoria")
    public ModelAndView filtrarPorCategoria(@RequestParam(required = false) String categoria) {
    List<Financeiro> financasFiltradas;
        
    if (categoria != null && !categoria.isEmpty()) { ////Verifica se a categoria é fornecida e não está vazia.
        financasFiltradas = FiltroRepository.findByCategoria(categoria);
        //utiliza o método findByCategoria do filtroRepository para buscar as finanças com a categoria especificada.
    } else {
        financasFiltradas = FiltroRepository.findAll();
    }

    ModelAndView mv = new ModelAndView("filtro");
    mv.addObject("listaFinancas", financasFiltradas);

    return mv;
}

@PostMapping("/filtrarPorDatas")
public ModelAndView filtrarPorDatas(@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInicio,
                                    @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFim) {
    List<Financeiro> financasFiltradas;
    //Se ambas as datas são fornecidas, utiliza o método findByDataBetween do filtroRepository para buscar as finanças com datas no intervalo especificado.
    if (dataInicio != null && dataFim != null) {
        financasFiltradas = FiltroRepository.findByDataBetween(dataInicio, dataFim);
    } else {
        financasFiltradas = FiltroRepository.findAll();
    }

    ModelAndView mv = new ModelAndView("filtro");
    mv.addObject("listaFinancas", financasFiltradas);

    return mv;
}


}
