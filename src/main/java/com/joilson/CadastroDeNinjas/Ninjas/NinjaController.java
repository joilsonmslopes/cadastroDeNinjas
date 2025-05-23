package com.joilson.CadastroDeNinjas.Ninjas;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Hello World! Bem vindo ao SpringBoot!";
    }

    // adicionar ninja
    @PostMapping("/cadastrar")
    public String createNinja() {
        return "Ninja Adicionado com sucesso";
    }

    // listar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaModel> getNinjas() {
        return ninjaService.getNinjas();
    }

    // buscar ninja por ID
    @GetMapping(value = "/listarId/{id}")
    public NinjaModel getNinjaById(@PathVariable long id) {
        return ninjaService.getNinjaById(id);
    }

    // atualizar informações de um ninja
    @PutMapping("/atualizar")
    public String updateNinja() {
        return "Ninja atualizad com sucesso";
    }

    // deletar um ninja
    @DeleteMapping("/deletar")
    public String deleteNinja() {
        return "Ninja deletado com sucesso";
    }
}
