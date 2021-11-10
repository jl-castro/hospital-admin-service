package com.dharbor.test.service.controller.profile;

import com.dharbor.test.service.command.profile.ProfileDeleteCmd;
import com.dharbor.test.service.command.profile.ProfileReadOneCmd;
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
public class ProfileDeleteController {

    @Autowired
    private ProfileDeleteCmd profileDeleteCmd;

    @ApiOperation(value = "Delete a profile")
    @DeleteMapping(value = "/{profileId}")
    public void deleteById(@PathVariable("profileId") String profileId) {
        profileDeleteCmd.setProfileId(profileId);
        profileDeleteCmd.execute();
    }
}
