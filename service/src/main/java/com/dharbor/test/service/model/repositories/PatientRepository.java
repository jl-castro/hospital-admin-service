package com.dharbor.test.service.model.repositories;

import com.dharbor.test.service.model.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jorge Castro
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
