package com.pw24.calcadatebase.controller;

import org.springframework.stereotype.Controller;
import com.pw24.calcadatebase.service.CalcaService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CalcaController {

    private final CalcaService service;

    public CalcaController(CalcaService service){
        this.service = service;

    }
    @GetMapping("/")
    public String inicialPage() {
        return "index";
    }
    
    
}
