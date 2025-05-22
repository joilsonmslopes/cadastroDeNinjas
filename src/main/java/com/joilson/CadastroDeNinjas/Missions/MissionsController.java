package com.joilson.CadastroDeNinjas.Missions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MissionsController {

    @GetMapping("/missoes")
    public String getMissoes() {
        return "Missões";
    }
}
