package com.css.challenge.coordinator;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.scrumMaster.ScrumMaster;
import com.css.challenge.student.Student;

public record CoordinatorRequestDTO(Long idPerson, String name, String email, String emailCompass, String cpf,
                                    boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                    String naturalNess, Student students, ScrumMaster scrumMaster, String squad, ClassEntity classEntity){
}
