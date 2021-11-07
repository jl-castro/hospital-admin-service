package com.dharbor.test.service.controller.profile;

import com.dharbor.test.service.command.profile.ProfileDeleteCmd;
import com.dharbor.test.service.command.profile.ProfileReadOneCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
