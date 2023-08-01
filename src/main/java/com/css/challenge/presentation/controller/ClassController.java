package com.css.challenge.presentation.controller;

import com.css.challenge.model.entity.ClassEntity;
import com.css.challenge.presentation.dto.ClassRecordDTO;
import com.css.challenge.model.repository.ClassRepository;
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
public class ClassController {
    @Autowired
    ClassRepository classRepository;

    @GetMapping("/classes")
    public ResponseEntity<List<ClassEntity>> getAllClasses(){
        return ResponseEntity.status(HttpStatus.OK).body(classRepository.findAll());
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity<Object> getOneClass(@PathVariable(value="id") Long id){
        Optional<ClassEntity> classEntity = classRepository.findById(id);
        if(classEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(classEntity.get());
    }

    @PostMapping("/classes")
    public ResponseEntity<ClassEntity> saveClass(@RequestBody @Valid ClassRecordDTO classRecordDTO){
        ClassEntity classEntityObj = new ClassEntity();
        BeanUtils.copyProperties(classRecordDTO, classEntityObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(classRepository.save(classEntityObj));
    }

    @PutMapping("/classes/{id}")
    public ResponseEntity<Object> updateClass(@PathVariable(value="id") Long id,
                                              @RequestBody @Valid ClassRecordDTO classRecordDTO){
        Optional<ClassEntity> classResponse = classRepository.findById(id);
        if(classResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class not found.");
        }
        ClassEntity classEntity = classResponse.get();
        BeanUtils.copyProperties(classRecordDTO, classEntity);
        return ResponseEntity.status(HttpStatus.OK).body(classRepository.save(classEntity));
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity<Object> deleteClass(@PathVariable(value="id") Long id){
        Optional<ClassEntity> classResponse = classRepository.findById(id);
        if(classResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Class not found.");
        }
        classRepository.delete(classResponse.get());
        return ResponseEntity.status(HttpStatus.OK).body("Class deleted successfully");
    }

}
