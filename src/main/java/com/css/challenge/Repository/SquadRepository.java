package com.css.challenge.Repository;

import com.css.challenge.Squad.Squad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadRepository extends JpaRepository<Squad, Long> {
}
