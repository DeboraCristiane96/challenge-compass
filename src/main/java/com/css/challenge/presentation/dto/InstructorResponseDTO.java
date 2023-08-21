package com.css.challenge.presentation.dto;

import com.css.challenge.model.entity.Instructor;

public record InstructorResponseDTO(String name, String email, String emailCompass, String cpf, boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode, String naturalNess, String coordinator, String scrumMaster, String squad){
    public InstructorResponseDTO(Instructor instructor){
        this( instructor.getName(),instructor.getEmail(),instructor.getEmailCompass(), instructor.getCpf(), instructor.isStatus(), instructor.getBirthDay(), instructor.getCivilStatus(),instructor.getSex(),instructor.getPhone(),instructor.getAdress(),instructor.getZipCode(),instructor.getNaturalNess(), instructor.getNameCoordinator(), instructor.getNameScrumMaster(), instructor.getNameSquad());
    }
}