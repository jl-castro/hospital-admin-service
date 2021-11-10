package com.dharbor.test.service.command.patient;

import com.dharbor.test.hospital.api.input.PatientInput;
import com.dharbor.test.service.exception.HospitalNotFoundException;
import com.dharbor.test.service.model.domain.Hospital;
import com.dharbor.test.service.model.domain.Patient;
import com.dharbor.test.service.model.repositories.HospitalRepository;
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
    private Long hospitalId;

    @Setter
    private PatientInput input;

    @Getter
    private Patient patient;

    @Autowired
    private PatientRepository repository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public void execute() {
        Hospital hospital = findHospital(hospitalId);
        patient = repository.save(composePatientInstance(input, hospital));
    }

    private Hospital findHospital(Long hospitalId) {
        return hospitalRepository.findById(hospitalId).orElseThrow(() -> new HospitalNotFoundException("Hospital not found with id: " + hospitalId));
    }

    private Patient composePatientInstance(PatientInput input, Hospital hospital) {

        Patient instance = new Patient();
        instance.setName(input.getName());
        instance.setLastName(input.getLastName());
        instance.setAddress(input.getAddress());
        instance.setProfileid(input.getProfileId());
        instance.setBirthday(input.getBirthday());
        instance.setCreatedBy(userId);
        instance.setHospital(hospital);

        return instance;
    }
}
