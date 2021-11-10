package com.dharbor.test.service.command.patient;

import com.dharbor.test.hospital.api.response.PatientResponse;
import com.dharbor.test.service.model.builder.PatientResponseBuilder;
import com.dharbor.test.service.model.domain.Patient;
import com.dharbor.test.service.model.repositories.PatientRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class PatientReadAllCmd implements BusinessLogicCommand {

    @Getter
    private List<PatientResponse> patients;

    @Autowired
    private PatientRepository repository;

    @Override
    public void execute() {
        patients = new ArrayList<>();
        validateDeleted();
    }

    private void validateDeleted() {
        List<Patient> patientList = repository.findAll()
                .stream()
                .filter(patient -> Boolean.FALSE.equals(patient.getIsDeleted()))
                .collect(Collectors.toList());
        patientList.forEach(patient -> patients.add(PatientResponseBuilder.getInstance(patient).build()));
    }
}
