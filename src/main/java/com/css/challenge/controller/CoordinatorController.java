package com.css.challenge.controller;

import com.css.challenge.Repository.CoordinatorRepository;
import com.css.challenge.coordinator.Coordinator;
import com.css.challenge.coordinator.CoordinatorRequestDTO;
import com.css.challenge.coordinator.CoordinatorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("coordinator")
public class CoordinatorController {
    @Autowired
    private CoordinatorRepository repository;
    @PostMapping
    public ResponseEntity saveCoordinator(@RequestBody CoordinatorRequestDTO data){
        try {
            Coordinator coordinatorData = new Coordinator(data);
            repository.save(coordinatorData);
            return new ResponseEntity(data, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //getAll
    @GetMapping
    public List<CoordinatorResponseDTO> getAll(){
        List<CoordinatorResponseDTO> coordinatorList = repository.findAll().stream()
                .map(CoordinatorResponseDTO::new).toList();
        return coordinatorList;
    }

    //getCoordinator
    @GetMapping("/{id}")
    public CoordinatorResponseDTO getCoordinator(@PathVariable (value = "id") Long id){
        CoordinatorResponseDTO coordinator = repository.findById(id)
                .map(CoordinatorResponseDTO::new).get();
        return coordinator;
    }

    //delete
    @DeleteMapping(value = "{id}")
    public ResponseEntity <Object> deleteCoordinator(@PathVariable (value = "id") Long id){
        Optional<Coordinator> Optional = repository.findById(id);
        if(!Optional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordinator not found."); }
        repository.delete(Optional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Coordinator deleted successfully.");
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCoordinator(@PathVariable (value = "id") Long id, @RequestBody CoordinatorRequestDTO data) {
        Optional<Coordinator> Optional = repository.findById(id);
        if (!Optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordinator not found.");
        }
        Coordinator coordinatorData = new Coordinator(data);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(coordinatorData));
    }
}
