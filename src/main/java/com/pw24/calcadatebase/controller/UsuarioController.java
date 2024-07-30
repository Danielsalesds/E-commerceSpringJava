package com.pw24.calcadatebase.controller;

import org.hibernate.annotations.AttributeAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pw24.calcadatebase.domain.Calca;
import com.pw24.calcadatebase.domain.Usuario;
import com.pw24.calcadatebase.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }
    @GetMapping("/usuarioCadastro")
    public String inicialPage(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        model.addAttribute("usuarios", service.findAll());
        return "usuariocadastro";
    }
    @PostMapping("/processCadastroUser")
    public String processCadastriUser (@ModelAttribute @Valid Usuario usuario, Errors errors){
        
        service.create(usuario);
        ModelAndView modelAndView = new ModelAndView("calcacadastro");
        modelAndView.addObject("msg", "Cadastro realizado com sucesso");
        return "redirect:/usuarioCadastro";
    }
    @GetMapping("/processDeleteUser/{id}")
    public String processDelete(@PathVariable("id") String id){
        service.delete(id);
        return "redirect:/usuarioCadastro";

    }




    
}
