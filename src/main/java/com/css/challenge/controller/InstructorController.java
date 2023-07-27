package com.css.challenge.controller;

import com.css.challenge.Repository.InstructorRepository;
import com.css.challenge.instructor.Instructor;
import com.css.challenge.instructor.InstructorRequestDTO;
import com.css.challenge.instructor.InstructorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("instructor")
public class InstructorController {
    @Autowired
    private InstructorRepository repository;


    @PostMapping
    public ResponseEntity saveInstructor(@RequestBody InstructorRequestDTO data){
        try {
            Instructor InstructorData = new Instructor(data);
            repository.save(InstructorData);
            return new ResponseEntity(data, HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<InstructorResponseDTO> getAll(){
        List<InstructorResponseDTO> instructorList = repository.findAll().stream()
                .map(InstructorResponseDTO::new).toList();
        return instructorList;
    }

    @GetMapping("/{id}")
    public InstructorResponseDTO getInstructor(@PathVariable (value = "id") Long id){
        InstructorResponseDTO instructor = repository.findById(id)
                .map(InstructorResponseDTO::new).get();
        return instructor;
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity <Object> deleteInstructor(@PathVariable (value = "id") Long id){
        Optional<Instructor> Optional = repository.findById(id);
        if(!Optional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found."); }
        repository.delete(Optional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Instructor deleted successfully."); }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateInstructor(@PathVariable (value = "id") Long id, @RequestBody InstructorRequestDTO data) {
        Optional<Instructor> Optional = repository.findById(id);
        if (!Optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instructor not found.");
        }
        Instructor InstructorData = new Instructor(data);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(InstructorData));
    }

}
