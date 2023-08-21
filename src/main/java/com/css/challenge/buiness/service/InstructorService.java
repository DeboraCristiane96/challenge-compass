package com.css.challenge.buiness.service;

import com.css.challenge.model.entity.QueryBuilder;
import com.css.challenge.model.repository.InstructorRepository;
import com.css.challenge.model.entity.Instructor;
import com.css.challenge.presentation.dto.InstructorRequestDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class InstructorService {
    @Autowired
    private InstructorRepository repository;

    public Instructor createInstructor(Instructor data) {
        return repository.save(data);
    }

    public Instructor updateInstructor(Long id, InstructorRequestDTO data) {

        Instructor instructor = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Instructor not found"));

        instructor.setName(data.name());
        instructor.setEmail(data.email());
        instructor.setEmailCompass(data.emailCompass());
        instructor.setCpf(data.cpf());
        instructor.setStatus(data.status());
        instructor.setBirthDay(data.birthDay());
        instructor.setCivilStatus(data.civilStatus());
        instructor.setSex(data.sex());
        instructor.setPhone(data.phone());
        instructor.setAdress(data.adress());
        instructor.setZipCode(data.zipCode());
        instructor.setNaturalNess(data.naturalNess());
        instructor.setNameCoordinator(data.coordinator());
        instructor.setNameScrumMaster(data.scrumMaster());
        instructor.setNameSquad(data.squad());

        return repository.save(instructor);
    }


    public List<Instructor> list(String name) {
        Example<Instructor> query = QueryBuilder.makeQuery(new Instructor());
        return repository.findAll(query);
    }

    public Optional<Instructor> findById(Long id){
        return repository.findById(id);
    }

    public Optional<Instructor> getByName(String name) {
        return repository.findByName(name);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
