package com.css.challenge.Repository;

import com.css.challenge.coordinator.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatorRepository extends JpaRepository<Coordinator, Long>{
}