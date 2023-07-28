package com.css.challenge.instructor;

public record InstructorResponseDTO(Long id, String name, String email, String emailCompass, String cpf, boolean status, String birthDay, String civilStatus, Character sex, String adress, int zipCode, String naturalNess, String coordinator, String scrumMaster, String squad){
    public InstructorResponseDTO(Instructor instructor){
        this(instructor.getId(),instructor.getName(),instructor.getEmail(),instructor.getEmailCompass(), instructor.getCpf(), instructor.isStatus(), instructor.getBirthDay(), instructor.getCivilStatus(),instructor.getSex(),instructor.getAdress(),instructor.getZipCode(),instructor.getNaturalNess(), instructor.getCoordinator(), instructor.getScrumMaster(), instructor.getSquad());
    }
}