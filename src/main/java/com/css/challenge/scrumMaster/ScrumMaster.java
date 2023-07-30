package com.css.challenge.scrumMaster;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.instructor.Instructor;
import com.css.challenge.interfaces.Person;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
@Table(name = "scrumMasters")
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


}
