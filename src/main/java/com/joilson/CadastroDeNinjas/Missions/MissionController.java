package com.joilson.CadastroDeNinjas.Missions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missoes")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissionDTO>> getAllMissions() {
        List<MissionDTO> missions = missionService.getAllMissions();
        return ResponseEntity.ok(missions);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> getMissionById(@PathVariable long id) {
        MissionDTO missionFound = missionService.listMissionById(id);

        if(missionFound != null) {
            return ResponseEntity.ok(missionFound);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missão com o (ID): " + id + " não foi encontrada!");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> createMission(@RequestBody MissionDTO mission) {
        MissionDTO missionCreated = missionService.createMission(mission);

        if (missionCreated != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(missionCreated);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao tentar registrar uma missão");
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<?> updateMissionById(@PathVariable long id, @RequestBody MissionDTO missionDTO) {
        MissionDTO mission = missionService.updateMission(id, missionDTO);

        if (mission != null) {
            return ResponseEntity.ok(mission);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A missão com o (id): " + id + " não foi encontrada!");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deleteMissionById(@PathVariable long id) {
        MissionDTO missionFound = missionService.listMissionById(id);

        if (missionFound != null) {
            missionService.deleteMissionByid(id);

            return ResponseEntity.ok("A missão: " + missionFound.getName() + " com o (ID): " + missionFound.getId() + " foi deletada com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão com o (ID): " + id + " não foi encontrada!");
    }
}
