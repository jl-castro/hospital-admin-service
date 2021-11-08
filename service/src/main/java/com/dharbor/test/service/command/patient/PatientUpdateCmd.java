package com.dharbor.test.service.command.patient;

import com.dharbor.test.hospital.api.input.PatientInput;
import com.dharbor.test.service.exception.PatientNotFoundException;
import com.dharbor.test.service.model.domain.Patient;
import com.dharbor.test.service.model.repositories.PatientRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class PatientUpdateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private Long patientId;

    @Setter
    private PatientInput input;

    @Getter
    private Patient patient;

    @Autowired
    private PatientRepository repository;

    @Override
    public void execute() {
        patient = findPatient(patientId);
        validate();
        patient = repository.save(updatePatient(patient));
    }

    private Patient findPatient(Long patientId) {
        return repository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(patient.getIsDeleted())) {
            throw new PatientNotFoundException("Patient not found with id: " + patientId);
        }
    }

    private Patient updatePatient(Patient instance) {
        instance.setName(input.getName());
        instance.setLastName(input.getLastName());
        instance.setAddress(input.getAddress());
        instance.setBirthday(input.getBirthday());
        instance.setUpdatedBy(userId);
        instance.setUpdatedAt(new Date());
        return instance;
    }
}
