package com.dharbor.test.service.controller.hospital;

import com.dharbor.test.hospital.api.input.HospitalInput;
import com.dharbor.test.hospital.api.response.HospitalResponse;
import com.dharbor.test.service.command.hospital.HospitalUpdateCmd;
import com.dharbor.test.service.model.builder.HospitalResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Jorge Castro
 */
@Api(
        tags = "Hospitals"
)
@RequestMapping(value = "/secure/hospitals")
@RequestScope
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HospitalUpdateController {

    @Autowired
    private HospitalUpdateCmd hospitalUpdateCmd;

    @ApiOperation(
            value = "Update a hospital"
    )
    @PutMapping(value = "/{hospitalId}")
    public HospitalResponse updateHospital(@RequestHeader("User-ID") Long userId,
                                           @PathVariable("hospitalId") Long hospitalId,
                                           @RequestBody HospitalInput input) {
        hospitalUpdateCmd.setUserId(userId);
        hospitalUpdateCmd.setHospitalId(hospitalId);
        hospitalUpdateCmd.setInput(input);
        hospitalUpdateCmd.execute();

        return HospitalResponseBuilder.getInstance(hospitalUpdateCmd.getHospital())
                .build();
    }
}
