package com.dharbor.test.service.controller.doctor;

import com.dharbor.test.hospital.api.input.DoctorInput;
import com.dharbor.test.hospital.api.response.DoctorResponse;
import com.dharbor.test.service.command.doctor.DoctorUpdateCmd;
import com.dharbor.test.service.model.builder.DoctorResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Jorge Castro
 */
@Api(
        tags = "Doctors"
)
@RequestMapping(value = "/secure/doctors")
@RequestScope
@RestController
public class DoctorUpdateController {

    @Autowired
    private DoctorUpdateCmd doctorUpdateCmd;

    @ApiOperation(
            value = "Update a doctor"
    )
    @PutMapping(value = "/{doctorId}")
    public DoctorResponse updateDoctor(@RequestHeader("User-ID") Long userId, @PathVariable("doctorId") Long doctorId, @RequestBody DoctorInput input) {
        doctorUpdateCmd.setUserId(userId);
        doctorUpdateCmd.setDoctorId(doctorId);
        doctorUpdateCmd.setInput(input);
        doctorUpdateCmd.execute();

        return DoctorResponseBuilder.getInstance(doctorUpdateCmd.getDoctor())
                .build();
    }
}
