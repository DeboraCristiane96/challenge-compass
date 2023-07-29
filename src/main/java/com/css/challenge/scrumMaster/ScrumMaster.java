package com.css.challenge.scrumMaster;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.instructor.Instructor;
import com.css.challenge.interfaces.Person;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
@Table(name = "scrumMaster")
@DiscriminatorValue(value = "ScrumMaster")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScrumMaster extends Person {

    //receive list of instructors that are participating
    private ArrayList<Instructor> instructors = new ArrayList<>();
    //receive list of squads that are participating
    //private ArrayList<Squad> squads = new ArrayList<>();
    private ClassEntity classEntity;
    private ScrumMaster scrumMaster;
    //private Squad squad;

    public ScrumMaster(ScrumMasterRequestDTO data){

        this.idPerson = data.idPerson();
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
       // this.squad = data.squad();

    }


}
