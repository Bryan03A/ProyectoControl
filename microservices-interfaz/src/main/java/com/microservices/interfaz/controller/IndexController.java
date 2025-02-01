package com.microservices.interfaz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String mostrarPaginaPrincipal() {
        return "index"; // Retorna el nombre del archivo index.html ubicado en src/main/resources/templates
    }
}