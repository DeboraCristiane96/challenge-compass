package com.css.challenge.interfaces;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Person")
public abstract class Person implements Serializable {


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
