package com.css.challenge.coordinator;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.instructor.Instructor;
import com.css.challenge.interfaces.Person;
import com.css.challenge.scrumMaster.ScrumMaster;
import com.css.challenge.student.Student;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;

@Table(name = "coordinators")
@DiscriminatorValue(value = "Coordinator")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordinator extends Person {

    //receive list of instructors that are participating
    private ArrayList<Instructor> instructors = new ArrayList<>();
    //receive list of students that are participating
    private ArrayList<Student> students =  new ArrayList<>();
    //the scrumMaster
    private ScrumMaster scrumMaster;
    private ClassEntity classEntity;
    private String squad;

    public Coordinator(CoordinatorRequestDTO data){

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
        this.scrumMaster = data.scrumMaster();
        this.squad = data.squad();

    }

    //permissions:
    //deletesomeone
    //addsomeone
    //updatesomeone

}
