package com.css.challenge.model.entity;

import com.css.challenge.model.interfaces.Person;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sm")
    private Long id;


    @OneToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = true)
    private ClassEntity classEntity;


}
