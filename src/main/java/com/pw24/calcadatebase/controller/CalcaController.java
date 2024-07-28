package com.pw24.calcadatebase.controller;

import org.springframework.stereotype.Controller;

import com.pw24.calcadatebase.domain.Calca;
import com.pw24.calcadatebase.service.CalcaService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalcaController {

    private final CalcaService service;

    public CalcaController(CalcaService service){
        this.service = service;

    }
    @GetMapping("/")
    public String inicialPage(Model model) {
        model.addAttribute("calca", service.findAll());

        return "index";
    }

    @GetMapping("/calcacadastrar")
    public String getCadastroPage(Model model) {
        Calca calca = new Calca();
        model.addAttribute("calca", calca);
        return "calcacadastro";
    }
        @PostMapping("/processCadastroPage")
        public ModelAndView processCadastroPage(@ModelAttribute @Valid Calca calca, Errors errors, @RequestParam("calca") MultipartFile file){
            if(errors.hasErrors()){
                return new ModelAndView("calcacadastro");
            }
            service.create(calca);
            ModelAndView modelAndView = new ModelAndView("index");
            modelAndView.addObject("msg", "Cadastro realizado com sucesso");
            modelAndView.addObject("calca", service.findAll());
            return modelAndView;


    }

    
    
}
