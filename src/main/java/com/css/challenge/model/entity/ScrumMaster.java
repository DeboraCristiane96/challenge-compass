package com.css.challenge.model.entity;

<<<<<<< HEAD:src/main/java/com/css/challenge/model/entity/ScrumMaster.java

=======
>>>>>>> b283c0321cdaa8a66bdb20cb8506d449b7e512fc:src/main/java/com/css/challenge/scrumMaster/ScrumMaster.java
import com.css.challenge.model.entity.ClassEntity;
import com.css.challenge.model.interfaces.Person;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
@Table(name = "scrumMasters")
@DiscriminatorValue(value = "ScrumMaster")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScrumMaster extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sm")
    private Long id;


    @OneToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id_class", nullable = true)
    private ClassEntity classEntity;


}
