package com.css.challenge.student;

public record StudentResponseDTO(String name,String email,String emailCompass,String cpf,boolean status,String birthDay,String civilStatus,Character sex,String phone,String adress,int zipCode,String naturalNess, int period, String course, String college) {

 /**
  *    public StudentResponseDTO(Student student){
  *         this(student.getId(), student.getPeriod(), student.getCourse(), student.getCollege());
  *     }
  *
  * */

}
