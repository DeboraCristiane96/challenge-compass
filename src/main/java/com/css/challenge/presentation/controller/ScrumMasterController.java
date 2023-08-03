package com.css.challenge.presentation.controller;

import com.css.challenge.model.entity.ScrumMaster;
import com.css.challenge.presentation.dto.ScrumMasterRequestDTO;
import com.css.challenge.model.repository.ScrumMasterRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/css/api")
public class ScrumMasterController {

    @Autowired
    ScrumMasterRepository scrumMasterRepository;

    @GetMapping("/sms")
    public ResponseEntity<List<ScrumMaster>> getAllSms(){
        return ResponseEntity.status(HttpStatus.OK).body(scrumMasterRepository.findAll());
    }

    @GetMapping("/sms/{id}")
    public ResponseEntity<Object> getOneSM(@PathVariable(value="id") Long id){
        Optional<ScrumMaster> scrumMaster = scrumMasterRepository.findById(id);
        if(scrumMaster.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SM not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(scrumMaster.get());
    }

    @PostMapping("/sms")
    public ResponseEntity<ScrumMaster> saveSM(@RequestBody @Valid ScrumMasterRequestDTO scrumMasterRequestDTO){
        ScrumMaster scrumMasterObj = new ScrumMaster();
        BeanUtils.copyProperties(scrumMasterRequestDTO, scrumMasterObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(scrumMasterRepository.save(scrumMasterObj));
    }

    @PutMapping("/sms/{id}")
    public ResponseEntity<Object> updateSM(@PathVariable(value="id") Long id,
                                              @RequestBody @Valid ScrumMasterRequestDTO scrumMasterRequestDTO){
        Optional<ScrumMaster> scrumMasterResponse = scrumMasterRepository.findById(id);
        if(scrumMasterResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SM not found.");
        }
        ScrumMaster scrumMaster = scrumMasterResponse.get();
        BeanUtils.copyProperties(scrumMasterRequestDTO, scrumMaster);
        return ResponseEntity.status(HttpStatus.OK).body(scrumMasterRepository.save(scrumMaster));
    }

    @DeleteMapping("/sms/{id}")
    public ResponseEntity<Object> deleteSM(@PathVariable(value="id") Long id){
        Optional<ScrumMaster> scrumMasterResponse = scrumMasterRepository.findById(id);
        if(scrumMasterResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("SM not found.");
        }
        scrumMasterRepository.delete(scrumMasterResponse.get());
        return ResponseEntity.status(HttpStatus.OK).body("SM deleted successfully");
    }
}
