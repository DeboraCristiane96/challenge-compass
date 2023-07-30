package com.css.challenge.instructor;

import com.css.challenge.interfaces.Person;
import jakarta.persistence.*;
import lombok.*;

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

    private String coordinator;
    private String scrumMaster;
    private String squad;

    private void receiveQuestion( ){}

   private String answerQuestion( ) {return "...";}
}
