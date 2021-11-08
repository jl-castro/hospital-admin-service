package com.dharbor.test.service.command.profile;

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
public class ProfileCreateCmd implements BusinessLogicCommand {

    @Setter
    private String userId;

    @Getter
    private Profile profile;

    @Setter
    private MultipartFile multipartFile;

    @Autowired
    private ProfileRepository repository;

    @Override
    public void execute() {
        profile = fillData(multipartFile);
    }

    private Profile fillData(MultipartFile file) {
        Profile instance = new Profile();
        instance.setUserId(userId);
        try {
            instance.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        repository.save(instance);

        return instance;
    }

}
