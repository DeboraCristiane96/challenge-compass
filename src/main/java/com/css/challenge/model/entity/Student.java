package com.css.challenge.model.entity;

<<<<<<< HEAD:src/main/java/com/css/challenge/model/entity/Student.java
import com.css.challenge.model.interfaces.Person;
=======
import com.css.challenge.Class.ClassEntity;
import com.css.challenge.Squad.Squad;
import com.css.challenge.interfaces.Person;
>>>>>>> f44d0b0a440f7cda3096fe2567b0c5eeb20f719f:src/main/java/com/css/challenge/student/Student.java
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
