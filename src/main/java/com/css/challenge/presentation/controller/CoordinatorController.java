package com.css.challenge.presentation.controller;



import com.css.challenge.model.entity.Coordinator;
import com.css.challenge.presentation.dto.CoordinatorRequestDTO;

import com.css.challenge.model.repository.CoordinatorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("css/api")
public class CoordinatorController {
    @Autowired
    private CoordinatorRepository repository;


    @PostMapping("coordinators")
    public ResponseEntity saveCoordinator(@RequestBody CoordinatorRequestDTO data){
        try {
            Coordinator coordinatorData = new Coordinator();
            BeanUtils.copyProperties(data, coordinatorData);
            repository.save(coordinatorData);
            return new ResponseEntity(coordinatorData, HttpStatus.CREATED);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("coordinators")
    public List<Coordinator> getAllCoordinators(){
        List<Coordinator> coordinatorList = repository.findAll();
        return coordinatorList;
    }

    @GetMapping("/coordinators/{id}")
    public ResponseEntity<Object> getCoordinator(@PathVariable (value = "id") Long id){
        Optional<Coordinator> coordinator = repository.findById(id);
        if(coordinator.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordinator not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(coordinator.get());
    }

    @DeleteMapping("/coordinators/{id}")
    public ResponseEntity <Object> deleteCoordinator(@PathVariable(value = "id") Long id){
        Optional<Coordinator> Optional = repository.findById(id);
        if(!Optional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordinator not found."); }
        repository.delete(Optional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Coordinator deleted successfully."); }

    @PutMapping("/coordinators/{id}")
    public ResponseEntity<Object> updateCoordinator(@PathVariable (value = "id") Long id, @RequestBody CoordinatorRequestDTO data) {
        Optional<Coordinator> optional = repository.findById(id);
        if (!optional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Coordinator not found.");
        }
        Coordinator coordinatorData = optional.get();
        BeanUtils.copyProperties(data, coordinatorData);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(coordinatorData));
    }
}
