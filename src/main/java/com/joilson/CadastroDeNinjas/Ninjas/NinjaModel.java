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

    private Long id;

    private String name;

    private String email;

    private int age;

    // @ManyToOne um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "mission_id") // Foreing key
    private MissionsModel mission;
}
