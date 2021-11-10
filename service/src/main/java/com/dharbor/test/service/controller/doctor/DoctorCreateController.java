package com.dharbor.test.service.controller.doctor;

import com.dharbor.test.hospital.api.input.DoctorInput;
import com.dharbor.test.hospital.api.response.DoctorResponse;
import com.dharbor.test.service.command.doctor.DoctorCreateCmd;
import com.dharbor.test.service.model.builder.DoctorResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DoctorCreateController {

    @Autowired
    private DoctorCreateCmd doctorCreateCmd;

    @ApiOperation(
            value = "Create a doctor"
    )
    @PostMapping
    public DoctorResponse createDoctor(@RequestHeader("User-ID") Long userId,
                                       @RequestHeader("hospitalId") Long hospitalId,
                                       @RequestBody DoctorInput input) {
        doctorCreateCmd.setUserId(userId);
        doctorCreateCmd.setHospitalId(hospitalId);
        doctorCreateCmd.setInput(input);
        doctorCreateCmd.execute();

        return DoctorResponseBuilder.getInstance(doctorCreateCmd.getDoctor())
                .build();
    }

}
