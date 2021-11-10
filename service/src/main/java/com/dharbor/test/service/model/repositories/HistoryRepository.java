package com.dharbor.test.service.model.repositories;

import com.dharbor.test.service.model.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jorge Castro
 */
public interface HistoryRepository extends JpaRepository<History, Long> {
}
