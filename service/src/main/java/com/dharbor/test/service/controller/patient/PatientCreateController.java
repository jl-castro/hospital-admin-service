package com.dharbor.test.service.controller.patient;

import com.dharbor.test.hospital.api.input.PatientInput;
import com.dharbor.test.hospital.api.response.PatientResponse;
import com.dharbor.test.service.command.patient.PatientCreateCmd;
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
public class PatientCreateController {

    @Autowired
    private PatientCreateCmd patientCreateCmd;

    @ApiOperation(
            value = "Create a patient"
    )
    @PostMapping
    public PatientResponse createPatient(@RequestHeader("User-ID") Long userId,
                                         @RequestHeader("hospitalId") Long hospitalId,
                                         @RequestBody PatientInput input) {
        patientCreateCmd.setUserId(userId);
        patientCreateCmd.setHospitalId(hospitalId);
        patientCreateCmd.setInput(input);
        patientCreateCmd.execute();

        Patient patient = patientCreateCmd.getPatient();

        return PatientResponseBuilder.getInstance(patient).build();
    }
}
