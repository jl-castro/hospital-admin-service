package com.dharbor.test.service.command.patient;

import com.dharbor.test.service.exception.PatientNotFoundException;
import com.dharbor.test.service.model.domain.Patient;
import com.dharbor.test.service.model.repositories.PatientRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class PatientReadOneCmd implements BusinessLogicCommand {

    @Setter
    private Long patientId;

    @Getter
    private Patient patient;

    @Autowired
    private PatientRepository repository;

    @Override
    public void execute() {
        patient = repository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
        validate(patient);
    }

    private void validate(Patient instance) {
        if (Boolean.TRUE.equals(instance.getIsDeleted())) {
            throw new PatientNotFoundException("Patient not found with id: " + patientId);
        }
    }
}
