package com.css.challenge.presentation.dto;


import com.css.challenge.model.entity.ClassEntity;

public record StudentRecordDTO(int period, String course, String college, String name, String email, String emailCompass, String cpf, boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode, String naturalNess, ClassEntity classEntity) {
}
