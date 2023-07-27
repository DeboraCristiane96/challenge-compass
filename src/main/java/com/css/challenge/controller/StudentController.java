package com.css.challenge.controller;

import com.css.challenge.Repository.StudentRepository;
import com.css.challenge.student.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @PostMapping
    public ResponseEntity saveStudent(@RequestBody StudentRequestDTO data){
        try{
            Student StudentData = new Student(data);
            repository.save(StudentData);
            return new ResponseEntity(data, HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
