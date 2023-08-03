package com.css.challenge.model.entity;

import com.css.challenge.model.repository.ClassRepository;
import com.css.challenge.presentation.controller.ClassController;
import com.css.challenge.presentation.dto.ClassRecordDTO;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClassControllerTest {

    @InjectMocks
    ClassController classController;

    @Mock
    ClassRepository classRepository;

    ClassEntity classEntity;

    ClassRecordDTO classRecordDTO;

    @BeforeEach
    public void setClassEntity(){
        classEntity = new ClassEntity(1L,"Spring Boot AWS", "05-06-2023", "05-12-2023", "Spring Boot", "AWS");

        classRecordDTO = new ClassRecordDTO("Spring Boot AWS", "05-06-2023", "05-12-2023", "Spring Boot", "AWS");
    }

    @Test
    public void deveBuscarTodasAsClasses(){
        when(classRepository.findAll()).thenReturn(Collections.singletonList(classEntity));
        ResponseEntity<List<ClassEntity>> classEntities = classController.getAllClasses();


        assertEquals(ResponseEntity.status(HttpStatus.OK).body(Collections.singletonList(classEntity)), classEntities);

        verify(classRepository).findAll();
        verifyNoMoreInteractions(classRepository);
    }

    @Test
    public void deveBuscarUmaClassPeloId(){
        when(classRepository.findById(classEntity.getId())).thenReturn(Optional.of(classEntity));


        // assertions
        ResponseEntity<Object> getOneClassTest = classController.getOneClass(classEntity.getId());

        assertEquals(ResponseEntity.status(HttpStatus.OK).body(classEntity), getOneClassTest);

        verify(classRepository).findById(classEntity.getId());
        verifyNoMoreInteractions(classRepository);

    }

    @Test
    public void getOneBuscarClassPeloIdDeveRetornarClassNãoEncontrada(){
        when(classRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());

        ResponseEntity test = classController.getOneClass(null);

        // action
        Assert.assertThat(test, is(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class not found.")));
    }

    @Test
    public void deveRetornarUmaClassPostada(){

        var response = classController.saveClass(classRecordDTO);
        assertEquals(ResponseEntity.status(HttpStatus.CREATED).body(classRepository.save(classEntity)), response);

        verify(classRepository).save(classEntity);
    }

    @Test
    public void deveAtualizarUmaClassPeloId(){
        when(classRepository.findById(classEntity.getId())).thenReturn(Optional.of(classEntity));

        ResponseEntity<Object> getPutClassTest = classController.updateClass(classEntity.getId(), classRecordDTO);
        assertEquals(ResponseEntity.status(HttpStatus.OK).body(classRepository.save(classEntity)), getPutClassTest);

        verify(classRepository).findById(classEntity.getId());
    }

    @Test
    public void putDeveBuscarClassPeloIdDeveRetornarClassNãoEncontrada(){
        when(classRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());

        ResponseEntity test = classController.updateClass(null, null);

        // action
        Assert.assertThat(test, is(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class not found.")));

    }

    @Test
    public void deveDeletarUmaClassPeloId(){
        when(classRepository.findById(classEntity.getId())).thenReturn(Optional.of(classEntity));

        ResponseEntity<Object> getDeleteClassTest = classController.deleteClass(classEntity.getId());
        assertEquals(ResponseEntity.status(HttpStatus.OK).body("Class deleted successfully"), getDeleteClassTest);

        verify(classRepository).findById(classEntity.getId());
    }

    @Test
    public void deletarUmClassRetornaClasNaoEncontrado(){
        when(classRepository.findById(ArgumentMatchers.any())).thenReturn(Optional.empty());

        ResponseEntity test = classController.deleteClass(null);

        // action
        Assert.assertThat(test, is(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class not found.")));
    }


}
