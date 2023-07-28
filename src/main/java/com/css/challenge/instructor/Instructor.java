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
@EqualsAndHashCode(of = "id")

public class Instructor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coordinator;
    private String scrumMaster;
    private String squad;

   public Instructor(InstructorRequestDTO data){
        this.name = data.name();
        this.email = data.email();
        this.emailCompass = data.emailCompass();
        this.cpf = data.cpf();
        this.status = data.status();
        this.birthDay = data.birthDay();
        this.civilStatus = data.civilStatus();
        this.sex = data.sex();
        this.phone = data.phone();
        this.adress = data.adress();
        this.zipCode = data.zipCode();
        this.naturalNess = data.naturalNess();
        this.coordinator = data.coordinator();
        this.scrumMaster = data.scrumMaster();
        this.squad = data.squad();

    }

    private void receiveQuestion( ){}

   private String answerQuestion( ) {return "...";}
}
