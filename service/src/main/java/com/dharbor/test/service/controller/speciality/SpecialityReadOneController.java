package com.dharbor.test.service.controller.speciality;

import com.dharbor.test.hospital.api.response.SpecialityResponse;
import com.dharbor.test.service.command.speciality.SpecialityReadOneCmd;
import com.dharbor.test.service.model.builder.SpecialityResponseBuilder;
import com.dharbor.test.service.model.domain.Speciality;
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
public class SpecialityReadOneController {

    @Autowired
    private SpecialityReadOneCmd specialityReadOneCmd;

    @ApiOperation(
            value = "Read a speciality"
    )
    @GetMapping(value = "/{specialityId}")
    public SpecialityResponse getById(@PathVariable("specialityId") Long specialityId) {
        specialityReadOneCmd.setSpecialityId(specialityId);
        specialityReadOneCmd.execute();
        Speciality speciality = specialityReadOneCmd.getSpeciality();

        return SpecialityResponseBuilder.getInstance(speciality).build();
    }
}
