package com.css.challenge.Repository;

import com.css.challenge.instructor.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> { }
