package com.dharbor.test.service.controller.patient;

import com.dharbor.test.hospital.api.response.PatientResponse;
import com.dharbor.test.service.command.patient.PatientReadOneCmd;
import com.dharbor.test.service.model.builder.PatientResponseBuilder;
import com.dharbor.test.service.model.domain.Patient;
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
public class PatientReadOneController {

    @Autowired
    private PatientReadOneCmd patientReadOneCmd;

    @ApiOperation(
            value = "Read a patient"
    )
    @GetMapping(value = "/{patientId}")
    public PatientResponse getById(@PathVariable("patientId") Long patientId) {
        patientReadOneCmd.setPatientId(patientId);
        patientReadOneCmd.execute();
        Patient patient = patientReadOneCmd.getPatient();

        return PatientResponseBuilder.getInstance(patient).build();
    }
}
