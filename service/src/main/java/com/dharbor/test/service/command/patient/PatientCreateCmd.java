package com.dharbor.test.service.command.patient;

import com.dharbor.test.hospital.api.input.PatientInput;
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
public class PatientCreateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private PatientInput input;

    @Getter
    private Patient patient;

    @Autowired
    private PatientRepository repository;

    @Override
    public void execute() {
        patient = repository.save(composePatientInstance(input));
    }

    private Patient composePatientInstance(PatientInput input) {
        Patient instance = new Patient();
        instance.setName(input.getName());
        instance.setLastName(input.getLastName());
        instance.setAddress(input.getAddress());
        instance.setBirthday(input.getBirthday());
        instance.setCreatedBy(userId);

        return instance;
    }
}
