package com.dharbor.test.service.model.builder;

import com.dharbor.test.hospital.api.response.ProfileResponse;
import com.dharbor.test.service.model.domain.Profile;

import java.util.Base64;

/**
 * @author Jorge Castro
 */
public class ProfileResponseBuilder {
    private ProfileResponse instance;

    public static ProfileResponseBuilder getInstance(Profile profile) {
        return (new ProfileResponseBuilder()).setProfile(profile);
    }

    private ProfileResponseBuilder() {
        instance = new ProfileResponse();
    }

    private ProfileResponseBuilder setProfile(Profile profile) {

        instance.setProfileId(profile.getId());
        instance.setImage(Base64.getEncoder().encodeToString(profile.getImage().getData()));
        instance.setUserId(profile.getUserId());

        return this;
    }

    public ProfileResponse build() {
        return instance;
    }
}
