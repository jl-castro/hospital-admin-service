package com.dharbor.test.service.controller.patient;

import com.dharbor.test.service.command.patient.PatientReadAllCmd;
import com.dharbor.test.service.model.domain.Patient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * @author Jorge Castro
 */
@Api(
        tags = "Patients"
)
@RequestMapping(value = "/secure/patients")
@RequestScope
@RestController
public class PatientReadAllController {

    @Autowired
    private PatientReadAllCmd patientReadAllCmd;

    @ApiOperation(
            value = "Read all patients"
    )
    @GetMapping
    public List<Patient> getAll() {
        patientReadAllCmd.execute();
        return patientReadAllCmd.getPatients();
    }

}
