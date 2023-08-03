package com.css.challenge.testingInstructor.repository;

import com.css.challenge.model.entity.Instructor;
import com.css.challenge.model.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;


import static com.css.challenge.common.InstructorConstants.INVALID_INSTRUCTOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static com.css.challenge.common.InstructorConstants.INSTRUCTOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DataJdbcTest
@SpringBootTest(classes = InstructorRepository.class)
public class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void  createInstructor_withValidData_ReturnsInstructor(){

        Instructor instructor = instructorRepository.save(INSTRUCTOR);

        Instructor sut = testEntityManager.find(Instructor.class, instructor.getId());

        System.out.println(sut.toString());

        assertThat(sut).isNotNull();

        assertThat(sut.getName()).isEqualTo(INSTRUCTOR.getId());

        assertThat(sut.getName()).isEqualTo(INSTRUCTOR.getName());
        assertThat(sut.getEmail()).isEqualTo(INSTRUCTOR.getEmail());
        assertThat(sut.getEmailCompass()).isEqualTo(INSTRUCTOR.getEmailCompass());
        assertThat(sut.getCpf()).isEqualTo(INSTRUCTOR.getCpf());
        assertThat(sut.getBirthDay()).isEqualTo(INSTRUCTOR.getBirthDay());
        assertThat(sut.getCivilStatus()).isEqualTo(INSTRUCTOR.getCivilStatus());
        assertThat(sut.getSex()).isEqualTo(INSTRUCTOR.getSex());
        assertThat(sut.getPhone()).isEqualTo(INSTRUCTOR.getPhone());
        assertThat(sut.getAdress()).isEqualTo(INSTRUCTOR.getAdress());
        assertThat(sut.getZipCode()).isEqualTo(INSTRUCTOR.getZipCode());
        assertThat(sut.getNaturalNess()).isEqualTo(INSTRUCTOR.getNaturalNess());
        assertThat(sut.getCoordinator()).isEqualTo(INSTRUCTOR.getCoordinator());
        assertThat(sut.getScrumMaster()).isEqualTo(INSTRUCTOR.getScrumMaster());
        assertThat(sut.getSquad()).isEqualTo(INSTRUCTOR.getSquad());

    }

    @Test
    public void createInstructor_WithInvalidData_ThrowsException() {
        Instructor emptyInstructor = new Instructor();

        assertThatThrownBy(() -> instructorRepository.save(emptyInstructor)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> instructorRepository.save(INVALID_INSTRUCTOR)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void createInstructor_WithExistingName_ThrowsException() {

        Instructor instructor = testEntityManager.persistFlushFind(INSTRUCTOR);
        testEntityManager.detach(instructor);
        instructor.setId(null);

        assertThatThrownBy(() -> instructorRepository.save(instructor)).isInstanceOf(RuntimeException.class);
    }

}
