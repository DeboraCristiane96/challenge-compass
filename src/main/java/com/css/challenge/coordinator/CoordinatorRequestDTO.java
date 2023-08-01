package com.css.challenge.coordinator;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.instructor.Instructor;
import com.css.challenge.scrumMaster.ScrumMaster;
import com.css.challenge.student.Student;

import java.util.List;

public record CoordinatorRequestDTO(String name, String email, String emailCompass, String cpf,
                                    boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                    String naturalNess, List<Instructor> instructors, ScrumMaster scrumMaster, ClassEntity classEntity){
}
