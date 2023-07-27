package com.css.challenge.student;

import com.css.challenge.interfaces.Person;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "student")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int period;
    private String course;
    private String college;
    
    
    public Student(StudentRequestDTO data){
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
        this.period = period;
        this.course = course;
        this.college = college;
    }

    
}
