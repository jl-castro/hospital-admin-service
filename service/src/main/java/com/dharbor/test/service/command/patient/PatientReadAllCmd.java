package com.dharbor.test.service.command.patient;

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
    private List<Patient> patients;

    @Autowired
    private PatientRepository repository;

    @Override
    public void execute() {
        patients = new ArrayList<>(validateDeleted());
    }

    private List<Patient> validateDeleted() {
        return repository.findAll()
                .stream()
                .filter(patient -> Boolean.FALSE.equals(patient.getIsDeleted()))
                .collect(Collectors.toList());
    }
}
