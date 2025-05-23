package com.joilson.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("boas-vindas")
    public String boasVindas() {
        return "Hello World! Bem vindo ao SpringBoot!";
    }

    // adicionar ninja
    @PostMapping("cadastrar")
    public String createNinja() {
        return "Ninja Adicionado com sucesso";
    }

    // listar todos os ninjas
    @GetMapping("listar")
    public String getNinjas() {
        return "Lista de ninjas";
    }

    // buscar ninja por ID
    @GetMapping("listarId")
    public String getNinjaById() {
        return "Meu Ninja";
    }

    // atualizar informações de um ninja
    @PutMapping("atualizar")
    public String updateNinja() {
        return "Ninja atualizad com sucesso";
    }

    // deletar um ninja
    @DeleteMapping("deletar")
    public String deleteNinja() {
        return "Ninja deletado com sucesso";
    }
}
