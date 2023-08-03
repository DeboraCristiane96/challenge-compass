package com.css.challenge.model.repository;

import com.css.challenge.model.entity.Instructor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>, QueryByExampleExecutor<Instructor> {

    Optional<Instructor> findByName(String name);
    @Override
    <S extends Instructor> List<S> findAll(Example<S> example);
}
