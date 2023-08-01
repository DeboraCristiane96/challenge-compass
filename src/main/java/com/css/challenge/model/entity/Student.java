package com.css.challenge.model.entity;

import com.css.challenge.model.interfaces.Person;
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


    private int period;
    private String course;
    private String college;

    
}
