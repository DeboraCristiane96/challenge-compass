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

    private String coordinator;
    private String scrumMaster;
    private String squad;

    private void receiveQuestion( ){}

   private String answerQuestion( ) {return "...";}
}
