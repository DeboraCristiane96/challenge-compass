package com.css.challenge.presentation.controller;

import com.css.challenge.model.entity.Squad;
import com.css.challenge.model.repository.SquadRepository;
import com.css.challenge.presentation.dto.SquadRecordDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("css/api")
public class SquadController {

    @Autowired
    private SquadRepository squadRepository;

    @GetMapping("/squads")
    public ResponseEntity<List<Squad>> getAllSquads(){
        return ResponseEntity.status(HttpStatus.OK).body(squadRepository.findAll());
    }

    @GetMapping("/squads/{id}")
    public ResponseEntity<Object> getOneSquad(@PathVariable(value="id") Long id){
        Optional<Squad> squad = squadRepository.findById(id);
        if(squad.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Squad not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(squad.get());
    }

    @PostMapping("/squads")
    public ResponseEntity<Squad> saveSquad(@RequestBody SquadRecordDTO squadRecordDTO){
        Squad squadObj = new Squad();
        BeanUtils.copyProperties(squadRecordDTO, squadObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(squadRepository.save(squadObj));
    }

    @PutMapping("/squads/{id}")
    public ResponseEntity<Object> updateSquad(@PathVariable(value="id") Long id,
                                              @RequestBody SquadRecordDTO squadRecordDTO){
        Optional<Squad> squadResponse = squadRepository.findById(id);
        if(squadResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Squad not found.");
        }
        Squad squad = squadResponse.get();
        BeanUtils.copyProperties(squadRecordDTO, squad);
        return ResponseEntity.status(HttpStatus.OK).body(squadRepository.save(squad));
    }

    @DeleteMapping("/squads/{id}")
    public ResponseEntity<Object> deleteSquad(@PathVariable(value="id") Long id){
        Optional<Squad> squadResponse = squadRepository.findById(id);
        if(squadResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Squad not found.");
        }
        squadRepository.delete(squadResponse.get());
        return ResponseEntity.status(HttpStatus.OK).body("Squad deleted successfully");
    }


}
