package com.dharbor.test.service.controller.patient;

import com.dharbor.test.hospital.api.input.PatientInput;
import com.dharbor.test.hospital.api.response.PatientResponse;
import com.dharbor.test.service.command.patient.PatientUpdateCmd;
import com.dharbor.test.service.model.builder.PatientResponseBuilder;
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
public class PatientUpdateController {

    @Autowired
    private PatientUpdateCmd patientUpdateCmd;

    @ApiOperation(
            value = "Update a patient"
    )
    @PutMapping(value = "/{patientId}")
    public PatientResponse updatePatient(@RequestHeader("User-ID") Long userId,
                                         @RequestHeader("hospitalId") Long hospitalId,
                                         @PathVariable("patientId") Long patientId,
                                         @RequestBody PatientInput input) {
        patientUpdateCmd.setUserId(userId);
        patientUpdateCmd.setPatientId(patientId);
        patientUpdateCmd.setHospitalId(hospitalId);
        patientUpdateCmd.setInput(input);
        patientUpdateCmd.execute();

        return PatientResponseBuilder.getInstance(patientUpdateCmd.getPatient())
                .build();
    }
}
