package com.css.challenge.model.entity;

import com.css.challenge.model.interfaces.Person;
import com.css.challenge.presentation.dto.InstructorRequestDTO;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;

@Table(name = "instructors")
@DiscriminatorValue(value = "Instructor")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Instructor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instructor")
    private Long id;

   @Column(nullable = false)
    private String coordinator;
    @Column(nullable = false)
    private String scrumMaster;
    @Column(nullable = false)
    private String squad;

   public Instructor(InstructorRequestDTO data){

        this.id = data.id();
        this.name = data.name();
        this.email = data.email();
        this.emailCompass = data.emailCompass();
        this.cpf = data.cpf();
        this.status = data.status();
        this.birthDay = data.birthDay();
        this.civilStatus = data.civilStatus();
        this.sex = data.sex();
        this.phone = data.phone();
        this.adress = data.adress();
        this.zipCode = data.zipCode();
        this.naturalNess = data.naturalNess();
        this.coordinator = data.coordinator();
        this.scrumMaster = data.scrumMaster();
        this.squad = data.squad();

    }


    public Instructor(Long id, String name, String email, String emailCompass,String cpf, boolean status , String birthDay,
                      String civilStatus,Character sex,String phone, String adress, int zipCode, String naturalNess,
                      String coordinator, String scrumMaster, String squad ) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.emailCompass = emailCompass;
        this.cpf = cpf;
        this.status = status;
        this.birthDay = birthDay;
        this.civilStatus = civilStatus;
        this.sex = sex;
        this.phone = phone;
        this.adress = adress;
        this.zipCode = zipCode;
        this.naturalNess = naturalNess;
        this.coordinator = coordinator;
        this.scrumMaster = scrumMaster;
        this.squad = squad;
   }

    private void receiveQuestion( ){}

   private String answerQuestion( ) {return "...";}



    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "coordinator='" + coordinator + '\'' +
                ", scrumMaster='" + scrumMaster + '\'' +
                ", squad='" + squad + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", emailCompass='" + emailCompass + '\'' +
                ", cpf='" + cpf + '\'' +
                ", status=" + status +
                ", birthDay='" + birthDay + '\'' +
                ", civilStatus='" + civilStatus + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                ", zipCode=" + zipCode +
                ", naturalNess='" + naturalNess + '\'' +
                '}';
    }
}
