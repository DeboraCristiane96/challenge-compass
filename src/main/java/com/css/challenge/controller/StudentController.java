package com.css.challenge.controller;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.Class.ClassRecordDTO;
import com.css.challenge.Repository.StudentRepository;
import com.css.challenge.student.*;
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
