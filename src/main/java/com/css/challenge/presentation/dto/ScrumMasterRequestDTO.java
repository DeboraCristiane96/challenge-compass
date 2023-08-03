package com.css.challenge.presentation.dto;


import com.css.challenge.model.entity.ClassEntity;

public record ScrumMasterRequestDTO(String name, String email, String emailCompass, String cpf,
                                    boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                    String naturalNess, ClassEntity classEntity) {
}
