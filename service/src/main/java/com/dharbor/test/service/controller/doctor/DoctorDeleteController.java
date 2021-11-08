package com.dharbor.test.service.controller.doctor;

import com.dharbor.test.service.command.doctor.DoctorDeleteCmd;
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
        tags = "Doctors"
)
@RequestMapping(value = "/secure/doctors")
@RequestScope
@RestController
public class DoctorDeleteController {

    @Autowired
    private DoctorDeleteCmd doctorDeleteCmd;

    @ApiOperation(
            value = "Delete a doctor"
    )
    @DeleteMapping(value = "/{doctorId}")
    public void deleteById(@PathVariable("doctorId") Long doctorId) {
        doctorDeleteCmd.setDoctorId(doctorId);
        doctorDeleteCmd.execute();
    }
}
