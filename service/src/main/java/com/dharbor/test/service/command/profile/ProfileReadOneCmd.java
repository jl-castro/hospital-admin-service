package com.dharbor.test.service.command.profile;

import com.dharbor.test.hospital.api.response.ProfileResponse;
import com.dharbor.test.service.exception.ProfileNotFoundException;
import com.dharbor.test.service.model.domain.Profile;
import com.dharbor.test.service.model.repositories.ProfileRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class ProfileReadOneCmd implements BusinessLogicCommand {
    @Setter
    private String userId;

    @Getter
    private Profile profile;

    @Autowired
    private ProfileRepository repository;

    @Override
    public void execute() {
        profile = findProfileByUserId(userId);
        if (null == profile) {
            throw new ProfileNotFoundException("profile not found with id: " + userId);
        }
    }

    private Profile findProfileByUserId(String userId) {
        return repository.findByUserId(userId);
    }

}
