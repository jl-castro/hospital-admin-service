package com.dharbor.test.service.controller.profile;

import com.dharbor.test.hospital.api.response.ProfileResponse;
import com.dharbor.test.service.command.profile.ProfileCreateCmd;
import com.dharbor.test.service.model.builder.ProfileResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Jorge Castro
 */
@Api(tags = "Profiles")
@RequestMapping(value = "/secure/profiles")
@RestController
@RequestScope
public class ProfileUpdateController {

    @Autowired
    private ProfileCreateCmd profileCreateCmd;

    @ApiOperation(value = "Update a profile")
    @PutMapping(consumes = "multipart/form-data", value = "/{profileId}")
    public ProfileResponse createProfile(@PathVariable("profileId") String profileId,
                                         @RequestHeader("User-ID") String userId,
                                         @RequestParam(value = "multipartFile") MultipartFile multipartFile) {
        profileCreateCmd.setUserId(userId);
        profileCreateCmd.setMultipartFile(multipartFile);
        profileCreateCmd.execute();

        return ProfileResponseBuilder.getInstance(profileCreateCmd.getProfile())
                .build();
    }
}
