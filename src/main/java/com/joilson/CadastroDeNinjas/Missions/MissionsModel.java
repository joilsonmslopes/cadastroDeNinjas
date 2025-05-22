package com.joilson.CadastroDeNinjas.Missions;

import java.util.List;

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
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Rank rank;

    // Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "mission")
    private List<NinjaModel> ninjas;
}
