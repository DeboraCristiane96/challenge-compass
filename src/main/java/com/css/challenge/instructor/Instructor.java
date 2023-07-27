package com.css.challenge.instructor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "instructors")
@Entity(name = "instructors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coordinator;
    private String scrumMaster;
    private String squad;

   public Instructor(InstructorRequestDTO data){
        this.coordinator = data.coordinator();
        this.scrumMaster = data.scrumMaster();
        this.squad = data.squad();
    }


    private void receiveQuestion( ){}

   private String answerQuestion( ) {return "...";}
}
