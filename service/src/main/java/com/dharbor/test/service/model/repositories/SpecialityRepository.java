package com.dharbor.test.service.model.repositories;

import com.dharbor.test.service.model.domain.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jorge Castro
 */
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {
}
