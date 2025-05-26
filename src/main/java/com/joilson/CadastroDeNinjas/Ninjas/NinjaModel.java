package com.joilson.CadastroDeNinjas.Ninjas;

import com.joilson.CadastroDeNinjas.Missions.MissionModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    private String rank;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private MissionModel mission;
}
