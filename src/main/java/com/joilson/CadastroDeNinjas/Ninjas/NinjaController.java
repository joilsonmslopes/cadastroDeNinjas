package com.joilson.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Rota para cadastro de um Ninja",
            description = "Essa rota é para criação de um novo ninja"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO newNinja = ninjaService.createNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + newNinja.getName() + " (ID): " + newNinja.getId());
    }

    @GetMapping("/listar")
    @Operation(
            summary = "Rota para listar todos os Ninjas",
            description = "Essa rota retorna uma lista de todos os ninjas cadastrados"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de ninjas retornada com sucesso")
    })
    public ResponseEntity<List<NinjaDTO>> getNinjas() {
        List<NinjaDTO> ninjas = ninjaService.getNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping(value = "/listar/{id}")
    @Operation(
            summary = "Rota para buscar um Ninja pelo ID",
            description = "Essa rota retorna um ninja específico com base no ID informado"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja encontrado"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> getNinjaById(
            @Parameter(description = "ID do Ninja a ser buscado", required = true)
            @PathVariable long id) {
        NinjaDTO ninja = ninjaService.getNinjaById(id);

        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID: " + id + " não foi encontrado!");
    }

    @PatchMapping("/atualizar/{id}")
    @Operation(
            summary = "Rota para atualizar um Ninja",
            description = "Essa rota permite atualizar os dados de um ninja existente",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados atualizados do ninja",
                    required = true,
                    content = @Content(schema = @Schema(implementation = NinjaDTO.class)))
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    public ResponseEntity<?> updateNinja(
            @Parameter(description = "ID do Ninja a ser atualizado", required = true)
            @PathVariable Long id,
            @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaUpdated = ninjaService.updateNinja(id, ninja);
        if (ninjaUpdated != null) {
            return ResponseEntity.ok(ninjaUpdated);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com o ID: " + id + " não foi encontrado!");
    }

    @DeleteMapping("/deletar/{id}")
    @Operation(
            summary = "Rota para deletar um Ninja",
            description = "Essa rota permite excluir um ninja com base no ID informado"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deleteNinja(@PathVariable Long id) {
        NinjaDTO ninjaFound = ninjaService.getNinjaById(id);

        if (ninjaFound != null) {
            ninjaService.deleteNinja(id);

            return ResponseEntity.ok("Ninja " + ninjaFound.getName() + " com o (ID): " + ninjaFound.getId() + " deletado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID: " + id + " não foi encontado");
    }
}
