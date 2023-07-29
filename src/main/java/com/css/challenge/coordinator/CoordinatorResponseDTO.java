package com.css.challenge.coordinator;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.scrumMaster.ScrumMaster;
import com.css.challenge.student.Student;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public record CoordinatorResponseDTO(Long idPerson, String name, String email, String emailCompass, String cpf,
                                     boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                     String naturalNess, ArrayList<Student> students, ScrumMaster scrumMaster, String squad, ClassEntity classEntity) {

    public CoordinatorResponseDTO(@NotNull Coordinator coordinator){
        this(coordinator.getIdPerson(), coordinator.getName(), coordinator.getEmail(), coordinator.getEmailCompass(),
                coordinator.getCpf(), coordinator.isStatus(), coordinator.getBirthDay(), coordinator.getCivilStatus(),
                coordinator.getSex(), coordinator.getPhone(), coordinator.getAdress(), coordinator.getZipCode(), coordinator.getNaturalNess(),
                coordinator.getStudents(), coordinator.getScrumMaster(), coordinator.getSquad(), coordinator.getClassEntity()
        );

    }
}