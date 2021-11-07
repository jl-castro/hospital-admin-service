package com.dharbor.test.service.model.repositories;

import com.dharbor.test.service.model.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jorge Castro
 */
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
