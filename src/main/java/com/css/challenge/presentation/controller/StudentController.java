package com.css.challenge.presentation.controller;

import com.css.challenge.model.repository.StudentRepository;
import com.css.challenge.model.entity.Student;
import com.css.challenge.presentation.dto.StudentRecordDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public ResponseEntity<Student> saveClass(@RequestBody @Valid StudentRecordDTO studentRecordDTO){
        Student studentObj = new Student();
        BeanUtils.copyProperties(studentRecordDTO, studentObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(studentObj));
    }

}
