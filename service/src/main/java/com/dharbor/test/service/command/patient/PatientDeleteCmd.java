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
public class PatientDeleteCmd implements BusinessLogicCommand {

    @Setter
    private Long patientId;

    @Getter
    private Patient patient;

    @Autowired
    private PatientRepository repository;

    @Override
    public void execute() {
        patient = findPatient(patientId);
        validate();
        patient = repository.save(softDelete(patient));
    }

    private Patient findPatient(Long patientId) {
        return repository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Hospital not found with id: " + patientId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(patient.getIsDeleted())) {
            throw new PatientNotFoundException("Patient not found with id: " + patientId);
        }
    }

    private Patient softDelete(Patient instance) {
        instance.setIsDeleted(true);
        return instance;
    }
}
