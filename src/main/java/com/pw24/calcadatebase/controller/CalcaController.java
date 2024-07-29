package com.pw24.calcadatebase.controller;

import org.springframework.stereotype.Controller;

import com.pw24.calcadatebase.domain.Calca;
import com.pw24.calcadatebase.service.CalcaService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "index";
    }
    @GetMapping("/updatePage")
    public String pageAtualizada(Model model){
        model.addAttribute("calcas", service.findAll());
        return "calcacadastro";
    }

    @GetMapping("/calcacadastrar")
    public String getCadastroPage(Model model) {
        Calca calca = new Calca();
        model.addAttribute("calca", calca);
        model.addAttribute("calcas", service.findAll());

        return "calcacadastro";
    }
    @PostMapping("/processCadastroPage")
    public String processCadastroPage(@ModelAttribute @Valid Calca calca, Errors errors){
        //if(errors.hasErrors()){
         //   return new ModelAndView("calcacadastro");
        //}
        calca.upperCaseCalcaName();
        service.create(calca);
        
        ModelAndView modelAndView = new ModelAndView("calcacadastro");
        modelAndView.addObject("msg", "Cadastro realizado com sucesso");
        //modelAndView.addObject("calcas", service.findAll());
        return "redirect:/calcacadastrar";


    }
    @GetMapping("/processDelete/{id}")
    public String processDelete(@PathVariable String id){
        service.delete(id);
        return "redirect:/calcacadastrar";

    }

    
    
}
