package com.dharbor.test.service.controller.doctor;

import com.dharbor.test.hospital.api.response.DoctorResponse;
import com.dharbor.test.service.command.doctor.DoctorReadOneCmd;
import com.dharbor.test.service.model.builder.DoctorResponseBuilder;
import com.dharbor.test.service.model.domain.Doctor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class DoctorReadOneController {

    @Autowired
    private DoctorReadOneCmd doctorReadOneCmd;

    @ApiOperation(
            value = "Read a doctor"
    )
    @GetMapping(value = "/{doctorId}")
    public DoctorResponse getById(@PathVariable("doctorId") Long doctorId) {
        doctorReadOneCmd.setDoctorId(doctorId);
        doctorReadOneCmd.execute();
        Doctor doctor = doctorReadOneCmd.getDoctor();

        return DoctorResponseBuilder.getInstance(doctor).build();
    }
}
