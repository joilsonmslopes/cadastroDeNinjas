package com.joilson.CadastroDeNinjas.Missions;

import com.joilson.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissionDTO {
    private long id;
    private String name;
    private String level;
    private List<NinjaModel> ninjas;
}
