package com.css.challenge.model.interfaces;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.io.Serializable;


@MappedSuperclass
@Data
public abstract class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idPerson;

    @NotEmpty
    @Column(nullable = false, unique = true)
    public String name;

    @NotEmpty
    @Column(nullable = false)
    public String email;

    @NotEmpty
    @Column(nullable = false)
    public String emailCompass;

    @NotEmpty
    @Column(nullable = false)
    public String cpf;

    @NotEmpty
    @Column(nullable = false)
    public boolean status;

    @NotEmpty
    @Column(nullable = false)
    public String birthDay;

    @NotEmpty
    @Column(nullable = false)
    public String civilStatus;

    @NotEmpty
    @Column(nullable = false)
    public Character sex;

    @NotEmpty
    @Column(nullable = false)
    public String phone;

    @NotEmpty
    @Column(nullable = false)
    public String adress;

    @NotEmpty
    @Column(nullable = false)
    public int zipCode;

    @NotEmpty
    @Column(nullable = false)
    public String naturalNess;

}
