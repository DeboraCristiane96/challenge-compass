package com.css.challenge.model.entity;

<<<<<<< HEAD
import com.css.challenge.model.interfaces.Person;
=======

import com.css.challenge.model.interfaces.Person;

>>>>>>> b283c0321cdaa8a66bdb20cb8506d449b7e512fc
import jakarta.persistence.*;
import lombok.*;


@Table(name = "students")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Long id;

    private int period;
    private String course;
    private String college;

    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = false)
    private ClassEntity classEntity;

}
