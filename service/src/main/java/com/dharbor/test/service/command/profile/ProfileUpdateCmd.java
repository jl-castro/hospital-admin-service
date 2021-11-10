package com.dharbor.test.service.command.profile;

import com.dharbor.test.service.exception.ProfileNotFoundException;
import com.dharbor.test.service.model.domain.Profile;
import com.dharbor.test.service.model.repositories.ProfileRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class ProfileUpdateCmd implements BusinessLogicCommand {

    @Setter
    private String profileId;

    @Getter
    private Profile profile;

    @Setter
    private MultipartFile multipartFile;

    @Autowired
    private ProfileRepository repository;

    @Override
    public void execute() {
        profile = findProfile(profileId);
        updateProfile(multipartFile);
    }

    private Profile findProfile(String profileId) {
        return repository.findById(profileId).orElseThrow(() -> new ProfileNotFoundException("Profile not found with id: " + profileId));
    }

    private void updateProfile(MultipartFile file) {
        try {
            profile.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        repository.save(profile);
    }
}
