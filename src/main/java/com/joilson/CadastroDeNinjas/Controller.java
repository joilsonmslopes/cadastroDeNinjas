package com.joilson.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("boas-vindas")
    public String boasVindas() {
        return "Hello World! Bem vindo ao SpringBoot!";
    }
}
