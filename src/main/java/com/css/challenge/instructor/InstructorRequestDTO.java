package com.css.challenge.instructor;

public record InstructorRequestDTO(Long idPerson, String name,String email,String emailCompass,String cpf,boolean status,String birthDay,String civilStatus,Character sex,String phone,String adress,int zipCode,String naturalNess,String coordinator, String scrumMaster,String squad) { }
