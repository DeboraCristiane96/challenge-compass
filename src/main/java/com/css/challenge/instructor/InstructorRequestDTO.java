package com.css.challenge.instructor;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.Squad.Squad;

import java.util.List;

public record InstructorRequestDTO(String name, String email, String emailCompass, String cpf, boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode, String naturalNess, ClassEntity classEntity) { }
