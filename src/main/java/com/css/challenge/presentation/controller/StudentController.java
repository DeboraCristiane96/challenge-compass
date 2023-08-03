package com.css.challenge.presentation.controller;

import com.css.challenge.model.repository.StudentRepository;
import com.css.challenge.model.entity.Student;
import com.css.challenge.presentation.dto.StudentRecordDTO;
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
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Object> getOneStudent(@PathVariable(value = "id") Long id){
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student wasn't found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student.get());
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable(value = "id") Long id, @RequestBody StudentRecordDTO studentRecordDTO){
        Optional<Student> studentResponse = studentRepository.findById(id);
        if (studentResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student wasn't found.");
        }
        Student student = studentResponse.get();
        BeanUtils.copyProperties(studentRecordDTO, student);
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.save(student));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(value = "id") Long id){
        Optional<Student> studentResponse = studentRepository.findById(id);
        if (studentResponse.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student wasn't found.");
        }
        studentRepository.delete(studentResponse.get());
        return ResponseEntity.status(HttpStatus.OK).body("Student was deleted successfully.");
    }


    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody StudentRecordDTO studentRecordDTO){
        Student studentObj = new Student();
        BeanUtils.copyProperties(studentRecordDTO, studentObj);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(studentObj));
    }

}
