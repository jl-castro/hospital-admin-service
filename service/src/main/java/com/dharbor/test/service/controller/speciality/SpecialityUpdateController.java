package com.dharbor.test.service.controller.speciality;

import com.dharbor.test.hospital.api.input.SpecialityInput;
import com.dharbor.test.hospital.api.response.SpecialityResponse;
import com.dharbor.test.service.command.speciality.SpecialityUpdateCmd;
import com.dharbor.test.service.model.builder.SpecialityResponseBuilder;
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
public class SpecialityUpdateController {

    @Autowired
    private SpecialityUpdateCmd specialityUpdateCmd;

    @ApiOperation(
            value = "Update a speciality"
    )
    @PutMapping(value = "/{specialityId}")
    public SpecialityResponse updateSpeciality(@RequestHeader("User-ID") Long userId, @PathVariable("specialityId") Long specialityId, @RequestBody SpecialityInput input) {
        specialityUpdateCmd.setUserId(userId);
        specialityUpdateCmd.setSpecialityId(specialityId);
        specialityUpdateCmd.setInput(input);
        specialityUpdateCmd.execute();

        return SpecialityResponseBuilder.getInstance(specialityUpdateCmd.getSpeciality())
                .build();
    }
}
