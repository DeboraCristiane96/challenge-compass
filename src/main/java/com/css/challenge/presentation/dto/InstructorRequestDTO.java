package com.css.challenge.presentation.dto;

import jakarta.validation.Valid;

public record InstructorRequestDTO(Long id, @Valid String name, @Valid String email,@Valid String emailCompass, @Valid String cpf, boolean status,@Valid String birthDay,@Valid String civilStatus,@Valid Character sex, @Valid String phone, @Valid String adress, int zipCode,@Valid String naturalNess,@Valid String coordinator,@Valid String scrumMaster,@Valid String squad) {

}
