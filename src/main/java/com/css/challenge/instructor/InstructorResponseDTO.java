package com.css.challenge.instructor;

public record InstructorResponseDTO(Long id, String coordinator, String scrumMaster, String squad) {
    public InstructorResponseDTO(Instructor instructor){
        this(instructor.getId(),instructor.getCoordinator(), instructor.getScrumMaster(), instructor.getSquad());
    }
}