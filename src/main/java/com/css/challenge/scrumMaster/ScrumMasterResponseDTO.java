package com.css.challenge.scrumMaster;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.instructor.Instructor;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public record ScrumMasterResponseDTO (Long idPerson, String name, String email, String emailCompass, String cpf,
                                      boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                      String naturalNess, ArrayList<Instructor> instructors, ClassEntity classEntity /*, Squad squads*/){
    public ScrumMasterResponseDTO(@NotNull ScrumMaster scrumMaster){
        this(scrumMaster.getIdPerson(), scrumMaster.getName(), scrumMaster.getEmail(), scrumMaster.getEmailCompass(),
                scrumMaster.getCpf(), scrumMaster.isStatus(), scrumMaster.getBirthDay(), scrumMaster.getCivilStatus(),
                scrumMaster.getSex(), scrumMaster.getPhone(), scrumMaster.getAdress(), scrumMaster.getZipCode(),
                scrumMaster.getNaturalNess(), scrumMaster.getInstructors(), scrumMaster.getClassEntity()
        );
    }
}
