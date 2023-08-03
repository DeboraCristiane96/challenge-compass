package com.css.challenge.model.repository;

import com.css.challenge.model.entity.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRepository extends JpaRepository<Squad, Long> {
}
