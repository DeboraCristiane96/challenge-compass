package com.css.challenge.Squad;

import com.css.challenge.student.Student;
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
    private Long id;
    private String name;
    private String instructor;

    @OneToMany
    @JoinColumn(name = "id_squad")
    private List<Student> students;
}