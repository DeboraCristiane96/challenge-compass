package com.css.challenge.model.interfaces;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@MappedSuperclass
@Data
public abstract class Person implements Serializable {

<<<<<<< HEAD:src/main/java/com/css/challenge/model/interfaces/Person.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idPerson;

    @Column(nullable = false)
=======
>>>>>>> f44d0b0a440f7cda3096fe2567b0c5eeb20f719f:src/main/java/com/css/challenge/interfaces/Person.java
    public String name;

    @Column(nullable = false)
    public String email;

    @Column(nullable = false)
    public String emailCompass;

    @Column(nullable = false)
    public String cpf;

    @Column(nullable = false)
    public boolean status;

    @Column(nullable = false)
    public String birthDay;

    @Column(nullable = false)
    public String civilStatus;

    @Column(nullable = false)
    public Character sex;

    @Column(nullable = false)
    public String phone;

    @Column(nullable = false)
    public String adress;

    @Column(nullable = false)
    public int zipCode;

    @Column(nullable = false)
    public String naturalNess;

}
