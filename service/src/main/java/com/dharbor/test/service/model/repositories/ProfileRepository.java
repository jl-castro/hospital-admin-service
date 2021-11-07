package com.dharbor.test.service.model.repositories;

import com.dharbor.test.service.model.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Jorge Castro
 */
public interface ProfileRepository extends MongoRepository<Profile, String> {
    @Query(value = "{'userId':{$regex:?0}}")
    Profile findByUserId(@Param("userId") String userId);
}
