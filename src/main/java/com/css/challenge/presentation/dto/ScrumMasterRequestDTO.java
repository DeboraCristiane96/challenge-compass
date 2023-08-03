package com.css.challenge.presentation.dto;

<<<<<<< HEAD:src/main/java/com/css/challenge/presentation/dto/ScrumMasterRequestDTO.java

import com.css.challenge.model.entity.ClassEntity;
//import com.css.challenge.squad.Squad;
=======
>>>>>>> b283c0321cdaa8a66bdb20cb8506d449b7e512fc:src/main/java/com/css/challenge/scrumMaster/ScrumMasterRequestDTO.java

import com.css.challenge.model.entity.ClassEntity;

public record ScrumMasterRequestDTO(String name, String email, String emailCompass, String cpf,
                                    boolean status, String birthDay, String civilStatus, Character sex, String phone, String adress, int zipCode,
                                    String naturalNess, ClassEntity classEntity) {
}
