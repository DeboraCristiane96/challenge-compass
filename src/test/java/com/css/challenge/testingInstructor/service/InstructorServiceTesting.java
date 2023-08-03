package com.css.challenge.testingInstructor.service;

import static com.css.challenge.common.InstructorConstants.INSTRUCTOR;
import static com.css.challenge.common.InstructorConstants.INVALID_INSTRUCTOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import com.css.challenge.buiness.service.InstructorService;
import com.css.challenge.model.entity.Instructor;
import com.css.challenge.model.entity.QueryBuilder;
import com.css.challenge.model.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

@ExtendWith(MockitoExtension.class)

public class InstructorServiceTesting {

    @InjectMocks
    private InstructorService instructorService;
    @Mock
    private InstructorRepository instructorRepository;
    @Test
    public void createInstructor_withValidData_ReturnsInstructor(){

        // Arrange
        when(instructorRepository.save(INSTRUCTOR)).thenReturn(INSTRUCTOR);
        // Act
        Instructor sut =  instructorService.createInstructor(INSTRUCTOR);
        // Assert
        assertThat(sut).isEqualTo(INSTRUCTOR);
    }

    @Test
    public void createInstructor_withInvalidData_ReturnsInstructor_TrowsException() {

        // Arrange
        when(instructorRepository.save(INVALID_INSTRUCTOR)).thenThrow(RuntimeException.class);

        // Assert
        assertThatThrownBy(() ->
        instructorService.createInstructor(INVALID_INSTRUCTOR)).isInstanceOf(RuntimeException.class);
    }
     @Test
     public void getInstructor_ByExistingID_ReturnsInstructor(){

        // Arrange
         when(instructorRepository.findById(INSTRUCTOR.getId())).thenReturn(Optional.of(INSTRUCTOR));

         // Act
         Optional<Instructor>  sut = instructorService.findById(INSTRUCTOR.getId());

         //Assert
         assertThat(sut).isNotEmpty();
         assertThat(sut.get()).isEqualTo(INSTRUCTOR);
     }
     @Test
     public void getInstructor_ByUnexistingId_ReturnEmpty(){

         // Arrange
         when(instructorRepository.findById(INSTRUCTOR.getId())).thenReturn(Optional.empty());

         // Act
         Optional<Instructor> sut = instructorService.findById(INSTRUCTOR.getId());

         //Assert
         assertThat(sut).isEmpty();
     }
     @Test
    public void getInstructor_ByExixtingName_ReturnInstructor(){
        //Arrange
         when(instructorRepository.findByName(INSTRUCTOR.name)).thenReturn(Optional.of(INSTRUCTOR));

         // Act
         Optional<Instructor>  sut = instructorService.getByName(INSTRUCTOR.name);

         //Assert
         assertThat(sut).isNotEmpty();
         assertThat(sut.get()).isEqualTo(INSTRUCTOR);
     }
    @Test
    public void getInstructor_ByUnexistingName_ReturnEmpty(){

        // Arrange
        when(instructorRepository.findByName(INSTRUCTOR.name)).thenReturn(Optional.empty());

        // Act
        Optional<Instructor> sut = instructorService.getByName(INSTRUCTOR.name);

        //Assert
        assertThat(sut).isEmpty();
    }

    @Test
    public void listInstructors_ReturnsAllInstructors() {
        List<Instructor> planets = new ArrayList<>() {
            {
                add(INSTRUCTOR);
            }
        };
        Example<Instructor> query = QueryBuilder.makeQuery(new Instructor());
        when(instructorRepository.findAll(query)).thenReturn(planets);

        List<Instructor> sut = instructorService.list(INSTRUCTOR.getName());

        assertThat(sut.get(0)).isEqualTo(INSTRUCTOR);
    }

    @Test
    public void removeInstructor_WithExistingId_doesNotThrowAnyException() {
        assertThatCode(() -> instructorService.delete(1L)).doesNotThrowAnyException();
    }

    @Test
    public void removeInstructor_WithUnexistingId_ThrowsException(){

        doThrow(new RuntimeException()).when(instructorRepository).deleteById(99L);

        assertThatThrownBy(() -> instructorService.delete(99L)).isInstanceOf(RuntimeException.class);
    }

}

