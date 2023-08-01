package com.css.challenge.coordinator;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.instructor.Instructor;
import com.css.challenge.interfaces.Person;
import com.css.challenge.scrumMaster.ScrumMaster;
import com.css.challenge.student.Student;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Table(name = "coordinators")
@DiscriminatorValue(value = "Coordinator")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coordinator extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coordinator")
    private Long id;
    //receive list of instructors that are participating
    @OneToMany
    @JoinColumn(name = "id_coordinator", referencedColumnName = "id_coordinator", nullable = true)
    private List<Instructor> instructors;

    //the scrumMaster
    @OneToOne
    @JoinColumn(name = "id_sm", referencedColumnName = "id_sm", nullable = true)
    private ScrumMaster scrumMaster;

    @OneToOne()
    @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = true)
    private ClassEntity classEntity;


    //permissions:
    //deletesomeone
    //addsomeone
    //updatesomeone

}
