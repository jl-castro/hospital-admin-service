package com.dharbor.test.service.controller.patient;

import com.dharbor.test.service.command.patient.PatientDeleteCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Jorge Castro
 */
@Api(
        tags = "Patients"
)
@RequestMapping(value = "/secure/patients")
@RequestScope
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PatientDeleteController {

    @Autowired
    private PatientDeleteCmd patientDeleteCmd;

    @ApiOperation(
            value = "Delete a patient"
    )
    @DeleteMapping(value = "/{patientId}")
    public void deleteById(@PathVariable("patientId") Long patientId) {
        patientDeleteCmd.setPatientId(patientId);
        patientDeleteCmd.execute();
    }
}
