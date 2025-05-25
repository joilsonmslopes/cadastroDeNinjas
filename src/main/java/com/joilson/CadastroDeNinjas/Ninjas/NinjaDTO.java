package com.joilson.CadastroDeNinjas.Ninjas;

import com.joilson.CadastroDeNinjas.Missions.MissionsModel;
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
    private MissionsModel mission;
    private String rank;
}
