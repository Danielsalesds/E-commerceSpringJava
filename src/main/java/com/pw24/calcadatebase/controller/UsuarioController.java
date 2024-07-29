package com.pw24.calcadatebase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pw24.calcadatebase.domain.Usuario;
import com.pw24.calcadatebase.service.UsuarioService;

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
        return "usuariocadastro";
    }




    
}
