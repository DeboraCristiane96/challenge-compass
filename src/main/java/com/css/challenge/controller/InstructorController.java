package com.css.challenge.controller;

import com.css.challenge.Class.ClassEntity;
import com.css.challenge.Class.ClassRecordDTO;
import com.css.challenge.Repository.InstructorRepository;
import com.css.challenge.instructor.Instructor;
import com.css.challenge.instructor.InstructorRequestDTO;
import com.css.challenge.instructor.InstructorResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("css/api")
public class InstructorController {
    @Autowired
    private InstructorRepository repository;


    @PostMapping("instructors")
    public ResponseEntity saveInstructor(@RequestBody InstructorRequestDTO data){
        try {
            Instructor instructorData = new Instructor();
            BeanUtils.copyProperties(data, instructorData);
            repository.save(instructorData);
            return new ResponseEntity(instructorData, HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("instructors")
    public List<Instructor> getAll(){
        List<Instructor> instructorList = repository.findAll();
        return instructorList;
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Object> getInstructor(@PathVariable (value = "id") Long id){
        Optional<Instructor> instructor = repository.findById(id);
        if(instructor.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(instructor.get());
    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity <Object> deleteInstructor(@PathVariable(value = "id") Long id){
        Optional<Instructor> Optional = repository.findById(id);
        if(!Optional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found."); }
        repository.delete(Optional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Instructor deleted successfully."); }

    @PutMapping("/instructors/{id}")
    public ResponseEntity<Object> updateInstructor(@PathVariable (value = "id") Long id, @RequestBody InstructorRequestDTO data) {
        Optional<Instructor> optional = repository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found.");
        }
        Instructor instructorData = optional.get();
        BeanUtils.copyProperties(data, instructorData);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(instructorData));
    }
}
