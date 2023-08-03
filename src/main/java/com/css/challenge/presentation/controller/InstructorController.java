package com.css.challenge.presentation.controller;

import com.css.challenge.model.entity.Instructor;
import com.css.challenge.presentation.dto.InstructorRequestDTO;
import com.css.challenge.buiness.service.InstructorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("instructors")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;


    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody @Valid Instructor data) {
        Instructor instructorCreated = instructorService.createInstructor(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorCreated);
    }

    @GetMapping
    public ResponseEntity <List<Instructor>> list(@RequestParam(required = false)String name){
          List<Instructor> instructors = instructorService.list(name);
          return ResponseEntity.ok(instructors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable (value = "id") Long id){
        return instructorService.findById(id).map(instructor ->ResponseEntity.ok(instructor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Instructor> getByName(@PathVariable("name") String name){
        return instructorService.getByName(name).map(instructor ->ResponseEntity.ok(instructor))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remove(@PathVariable("id") Long id) {
        instructorService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    public ResponseEntity<Object> updateInstructor(@PathVariable Long id, @RequestBody InstructorRequestDTO data ) {
        try {
            Instructor instructorUpdate = instructorService.updateInstructor(id, data);
            return ResponseEntity.ok(instructorUpdate);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
