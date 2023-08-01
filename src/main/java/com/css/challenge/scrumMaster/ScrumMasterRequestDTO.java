package com.css.challenge.scrumMaster;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.instructor.Instructor;
//import com.css.challenge.squad.Squad;

public record ScrumMasterRequestDTO( String name, String email, String emailCompass, String cpf,
                                    boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                    String naturalNess, ClassEntity classEntity) {
}
