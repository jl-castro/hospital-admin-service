package com.dharbor.test.service.controller.profile;

import com.dharbor.test.hospital.api.response.ProfileResponse;
import com.dharbor.test.service.command.profile.ProfileUpdateCmd;
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
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProfileUpdateController {

    @Autowired
    private ProfileUpdateCmd profileUpdateCmd;

    @ApiOperation(value = "Update a profile")
    @PutMapping(consumes = "multipart/form-data", value = "/{profileId}")
    public ProfileResponse updateProfile(@PathVariable("profileId") String profileId,
                                         @RequestParam(value = "multipartFile") MultipartFile multipartFile) {
        profileUpdateCmd.setProfileId(profileId);
        profileUpdateCmd.setMultipartFile(multipartFile);
        profileUpdateCmd.execute();

        return ProfileResponseBuilder.getInstance(profileUpdateCmd.getProfile())
                .build();
    }
}
