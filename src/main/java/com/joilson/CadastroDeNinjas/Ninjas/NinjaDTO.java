package com.joilson.CadastroDeNinjas.Ninjas;

import com.joilson.CadastroDeNinjas.Missions.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private long id;
    private String name;
    private String email;
    private int age;
    private MissionModel mission;
    private String rank;
}
