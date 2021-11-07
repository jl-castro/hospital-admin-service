package com.dharbor.test.service.command.profile;

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
public class ProfileDeleteCmd implements BusinessLogicCommand {

    @Setter
    private String profileId;

    @Getter
    private Profile profile;

    @Autowired
    private ProfileRepository repository;

    @Override
    public void execute() {
        validate();
        repository.deleteById(profileId);
    }

    private void validate() {
        profile = repository.findById(profileId).orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + profileId));
    }
}
