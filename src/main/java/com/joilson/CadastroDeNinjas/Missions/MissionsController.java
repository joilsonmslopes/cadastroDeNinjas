package com.joilson.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/missoes")
public class MissionsController {

    @GetMapping("/buscar")
    public String getMissoes() {
        return "Lista de Missões";
    }

    @PostMapping("/criar")
    public String createMission() {
        return "Missão criada com sucesso";
    }

    @GetMapping("/listarId")
    public String getMissionById() {
        return "Minha Missão";
    }

    @PutMapping("/atualizarId")
    public String updateMissionById() {
        return "Missão atualizada com sucesso";
    }

    @DeleteMapping("/deletarId")
    public String deleteMissionById() {
        return "Missão deletada com sucesso";
    }
}
