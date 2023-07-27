package com.css.challenge.controller;

import com.css.challenge.Repository.InstructorRepository;
import com.css.challenge.instructor.Instructor;
import com.css.challenge.instructor.InstructorRequestDTO;
import com.css.challenge.instructor.InstructorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instructor")
public class InstructorController {
    @Autowired
    private InstructorRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveInstructor(@RequestBody InstructorRequestDTO data){
        Instructor InstructorData = new Instructor(data);
        repository.save(InstructorData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<InstructorResponseDTO> getAll(){
        List<InstructorResponseDTO> instructorList = repository.findAll().stream()
                .map(InstructorResponseDTO::new).toList();
        return instructorList;
    }
}
