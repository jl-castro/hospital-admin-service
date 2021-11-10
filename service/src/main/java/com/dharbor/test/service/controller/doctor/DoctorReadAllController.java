package com.dharbor.test.service.controller.doctor;

import com.dharbor.test.hospital.api.response.DoctorResponse;
import com.dharbor.test.service.command.doctor.DoctorReadAllCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

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
public class DoctorReadAllController {

    @Autowired
    private DoctorReadAllCmd doctorReadAllCmd;

    @ApiOperation(
            value = "Read all doctors"
    )
    @GetMapping
    public List<DoctorResponse> getAll() {
        doctorReadAllCmd.execute();

        return doctorReadAllCmd.getDoctorsResponseList();
    }

}
