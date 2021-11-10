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
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProfileCreateController {

    @Autowired
    private ProfileCreateCmd profileCreateCmd;

    @ApiOperation(value = "Create a profile")
//    @PostMapping(consumes = "multipart/form-data")
    @PostMapping
    public ProfileResponse createProfile(@RequestParam(value = "multipartFile") MultipartFile multipartFile) {
        profileCreateCmd.setMultipartFile(multipartFile);
        profileCreateCmd.execute();

        return ProfileResponseBuilder.getInstance(profileCreateCmd.getProfile())
                .build();
    }
}
