package com.css.challenge.presentation.dto;

import com.css.challenge.model.entity.ClassEntity;
import com.css.challenge.model.entity.Instructor;
import com.css.challenge.model.entity.ScrumMaster;

<<<<<<< HEAD:src/main/java/com/css/challenge/presentation/dto/CoordinatorRequestDTO.java
=======

import com.css.challenge.model.entity.ClassEntity;
import com.css.challenge.model.entity.Instructor;
import com.css.challenge.scrumMaster.ScrumMaster;
>>>>>>> b283c0321cdaa8a66bdb20cb8506d449b7e512fc:src/main/java/com/css/challenge/coordinator/CoordinatorRequestDTO.java

import java.util.List;

public record CoordinatorRequestDTO(String name, String email, String emailCompass, String cpf,
                                    boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                    String naturalNess, List<Instructor> instructors, ScrumMaster scrumMaster, ClassEntity classEntity){
}
