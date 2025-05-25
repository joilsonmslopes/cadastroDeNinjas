package com.joilson.CadastroDeNinjas.Ninjas;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/cadastrar")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + newNinja.getName() + " (ID): " + newNinja.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> getNinjas() {
        List<NinjaDTO> ninjas = ninjaService.getNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping(value = "/listar/{id}")
    public ResponseEntity<?> getNinjaById(@PathVariable long id) {
        NinjaDTO ninja = ninjaService.getNinjaById(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID: " + id + " não foi encontrado!");
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<?> updateNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaUpdated = ninjaService.updateNinja(id, ninja);
        if (ninjaUpdated != null) {
            return ResponseEntity.ok(ninjaUpdated);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com o ID: " + id + " não foi encontrado!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteNinja(@PathVariable Long id) {
        NinjaDTO ninjaFound = ninjaService.getNinjaById(id);

        if (ninjaFound != null) {
            ninjaService.deleteNinja(id);

            return ResponseEntity.ok("Ninja " + ninjaFound.getName() + " com o (ID): " + ninjaFound.getId() + " deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID: " + id + " não foi encontado");


    }
}
