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
    private String instructor;
    //receive list of students that are participating
    private String student;
    //the scrumMaster
    private ScrumMaster scrumMaster;
    private ClassEntity classEntity;
    private String squad;


    //permissions:
    //deletesomeone
    //addsomeone
    //updatesomeone

}
