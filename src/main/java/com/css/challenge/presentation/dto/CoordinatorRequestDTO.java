package com.css.challenge.presentation.dto;

import com.css.challenge.model.entity.ClassEntity;
import com.css.challenge.model.entity.Instructor;
import com.css.challenge.model.entity.ScrumMaster;

import java.util.List;

public record CoordinatorRequestDTO(String name, String email, String emailCompass, String cpf,
                                    boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                    String naturalNess, List<Instructor> instructors, ScrumMaster scrumMaster, ClassEntity classEntity){
}
