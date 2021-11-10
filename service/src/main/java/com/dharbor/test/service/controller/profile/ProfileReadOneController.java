package com.dharbor.test.service.controller.profile;

import com.dharbor.test.hospital.api.response.ProfileResponse;
import com.dharbor.test.service.command.profile.ProfileReadOneCmd;
import com.dharbor.test.service.model.builder.ProfileResponseBuilder;
import com.dharbor.test.service.model.domain.Profile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Jorge Castro
 */
@Api(tags = "Profiles")
@RequestMapping(value = "/secure/profiles")
@RestController
@RequestScope
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProfileReadOneController {

    @Autowired
    private ProfileReadOneCmd profileReadOneCmd;

    @ApiOperation(value = "Read a profile")
    @GetMapping(value = "/{profileId}")
    public ProfileResponse getById(@PathVariable("profileId") String profileId) {
        profileReadOneCmd.setProfileId(profileId);
        profileReadOneCmd.execute();
        Profile profile = profileReadOneCmd.getProfile();

        return ProfileResponseBuilder.getInstance(profile)
                .build();
    }
}
