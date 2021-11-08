package com.dharbor.test.service.controller.speciality;

import com.dharbor.test.service.command.speciality.SpecialityDeleteCmd;
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
@Api(
        tags = "Specialities"
)
@RequestMapping(value = "/secure/specialities")
@RequestScope
@RestController
public class SpecialityDeleteController {

    @Autowired
    private SpecialityDeleteCmd specialityDeleteCmd;

    @ApiOperation(
            value = "Delete a speciality"
    )
    @DeleteMapping(value = "/{specialityId}")
    public void deleteById(@PathVariable("specialityId") Long specialityId) {
        specialityDeleteCmd.setSpecialityId(specialityId);
        specialityDeleteCmd.execute();
    }
}
