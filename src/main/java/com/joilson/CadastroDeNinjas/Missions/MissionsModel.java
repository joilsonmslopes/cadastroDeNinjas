package com.joilson.CadastroDeNinjas.Missions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.joilson.CadastroDeNinjas.Rank;
import com.joilson.CadastroDeNinjas.Ninjas.NinjaModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_missions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String level;

    // Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "mission")
    @JsonIgnore
    private List<NinjaModel> ninjas;
}
