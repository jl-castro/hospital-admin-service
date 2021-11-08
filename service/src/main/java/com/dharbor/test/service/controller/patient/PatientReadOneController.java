package com.dharbor.test.service.controller.patient;

import com.dharbor.test.hospital.api.response.PatientResponse;
import com.dharbor.test.service.command.patient.PatientReadOneCmd;
import com.dharbor.test.service.model.builder.PatientResponseBuilder;
import com.dharbor.test.service.model.domain.Patient;
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
        tags = "Patients"
)
@RequestMapping(value = "/secure/patients")
@RequestScope
@RestController
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
