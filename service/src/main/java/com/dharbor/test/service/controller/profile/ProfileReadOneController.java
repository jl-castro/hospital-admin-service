package com.dharbor.test.service.controller.profile;

import com.dharbor.test.hospital.api.response.ProfileResponse;
import com.dharbor.test.service.command.profile.ProfileReadOneCmd;
import com.dharbor.test.service.model.builder.ProfileResponseBuilder;
import com.dharbor.test.service.model.domain.Profile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Jorge Castro
 */
@Api(tags = "Profiles")
@RequestMapping(value = "/secure/profiles")
@RestController
@RequestScope
public class ProfileReadOneController {

    @Autowired
    private ProfileReadOneCmd profileReadOneCmd;

    @ApiOperation(value = "Read a profile")
    @GetMapping(value = "/{userId}")
    public ProfileResponse getById(@PathVariable("userId") String userId) {
        profileReadOneCmd.setUserId(userId);
        profileReadOneCmd.execute();
        Profile profile = profileReadOneCmd.getProfile();

        return ProfileResponseBuilder.getInstance(profile)
                .build();
    }
}
