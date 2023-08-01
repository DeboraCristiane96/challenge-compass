package com.css.challenge.testingInstructor.repository;

import com.css.challenge.model.entity.Instructor;
import com.css.challenge.model.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.css.challenge.common.InstructorConstants.INSTRUCTOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DataJdbcTest
public class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void  createInstructor_withValidData_ReturnsInstructor(){

        Instructor instructor = instructorRepository.save(INSTRUCTOR);

        Instructor sut = testEntityManager.find(Instructor.class, instructor.getIdPerson());

        System.out.println(sut.toString());

        assertThat(sut).isNotNull();
        assertThat(sut.getName()).isEqualTo(INSTRUCTOR.getIdPerson());
        assertThat(sut.getName()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getEmail()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getEmailCompass()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getCpf()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getBirthDay()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getCivilStatus()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getSex()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getPhone()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getAdress()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getZipCode()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getNaturalNess()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getCoordinator()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getScrumMaster()).isEqualTo(INSTRUCTOR.getScrumMaster());
        assertThat(sut.getSquad()).isEqualTo(INSTRUCTOR.getSquad());

    }

    @Test
    public void createInstructor_WithInvalidData_ThrowsException() {
        Instructor emptyInstructor = new Instructor();
        Instructor invalidInstructor = new Instructor(2L,"","","","",false
                ,"","",' ',"","",0,"","","","");

        assertThatThrownBy(() -> instructorRepository.save(emptyInstructor)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> instructorRepository.save(invalidInstructor)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void createInstructor_WithExistingName_ThrowsException() {
        Instructor instructor = testEntityManager.persistFlushFind(INSTRUCTOR);
        testEntityManager.detach(instructor);
        instructor.setIdPerson(null);

        assertThatThrownBy(() -> instructorRepository.save(instructor)).isInstanceOf(RuntimeException.class);
    }

}
