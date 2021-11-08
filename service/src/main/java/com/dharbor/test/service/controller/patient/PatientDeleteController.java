package com.dharbor.test.service.controller.patient;

import com.dharbor.test.service.command.patient.PatientDeleteCmd;
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
        tags = "Patients"
)
@RequestMapping(value = "/secure/patients")
@RequestScope
@RestController
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
