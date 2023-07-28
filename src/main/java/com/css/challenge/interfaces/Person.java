package com.css.challenge.interfaces;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@MappedSuperclass
@Data
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idPerson;

    public String name;

    public String email;

    public String emailCompass;

    public String cpf;

    public boolean status;

    public String birthDay;

    public String civilStatus;

    public Character sex;

    public String phone;

    public String adress;

    public int zipCode;

    public String naturalNess;

}
