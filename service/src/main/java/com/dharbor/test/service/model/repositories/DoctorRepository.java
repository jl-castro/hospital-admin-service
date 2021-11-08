package com.dharbor.test.service.model.repositories;

import com.dharbor.test.service.model.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jorge Castro
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
