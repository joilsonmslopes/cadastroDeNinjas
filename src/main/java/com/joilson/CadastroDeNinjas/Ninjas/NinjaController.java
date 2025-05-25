package com.joilson.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/")
    public String boasVindas() {
        return "Bem vindo a API de Cadastro de Ninjas!";
    }

    // adicionar ninja
    @PostMapping("/cadastrar")
    public NinjaDTO createNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.createNinja(ninja);
    }

    // listar todos os ninjas
    @GetMapping("/listar")
    public List<NinjaDTO> getNinjas() {
        return ninjaService.getNinjas();
    }

    // buscar ninja por ID
    @GetMapping(value = "/listarId/{id}")
    public NinjaDTO getNinjaById(@PathVariable long id) {
        return ninjaService.getNinjaById(id);
    }

    // atualizar informações de um ninja
    @PatchMapping("/atualizar/{id}")
    public NinjaDTO updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.updateNinja(id, ninja);
    }

    // deletar um ninja
    @DeleteMapping("/deletar/{id}")
    public void deleteNinja(@PathVariable Long id) {
        ninjaService.deleteNinja(id);
    }
}
