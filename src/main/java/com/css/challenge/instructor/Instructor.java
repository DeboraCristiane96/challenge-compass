package com.css.challenge.instructor;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.Squad.Squad;
import com.css.challenge.interfaces.Person;
import com.css.challenge.scrumMaster.ScrumMaster;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "instructors")
@DiscriminatorValue(value = "Instructor")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Instructor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instructor")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = true)
    private ClassEntity classEntity;

    private void receiveQuestion( ){}

   private String answerQuestion( ) {return "...";}
}
