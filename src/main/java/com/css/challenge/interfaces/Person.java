package com.css.challenge.interfaces;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Person")
@MappedSuperclass
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
