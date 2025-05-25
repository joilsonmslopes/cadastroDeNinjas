package com.joilson.CadastroDeNinjas.Ninjas;

import com.joilson.CadastroDeNinjas.Missions.MissionsModel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity - Transforma a classe em uma entidade do banco de dados
// JPA - Java Persistence API

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
    private MissionsModel mission;
}
