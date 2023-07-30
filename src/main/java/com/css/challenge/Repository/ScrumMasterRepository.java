package com.css.challenge.Repository;

import com.css.challenge.coordinator.Coordinator;
import com.css.challenge.scrumMaster.ScrumMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrumMasterRepository extends JpaRepository<ScrumMaster, Long> {
}
