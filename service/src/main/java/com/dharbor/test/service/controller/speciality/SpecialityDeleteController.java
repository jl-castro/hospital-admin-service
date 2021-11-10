package com.dharbor.test.service.controller.speciality;

import com.dharbor.test.service.command.speciality.SpecialityDeleteCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
