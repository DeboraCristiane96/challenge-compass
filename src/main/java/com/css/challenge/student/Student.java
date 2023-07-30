package com.css.challenge.student;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.Squad.Squad;
import com.css.challenge.interfaces.Person;
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
