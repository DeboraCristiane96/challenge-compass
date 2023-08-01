package com.css.challenge.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "SQUADS")

public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_squad")
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "id_squad")
    private List<Student> students;
}
