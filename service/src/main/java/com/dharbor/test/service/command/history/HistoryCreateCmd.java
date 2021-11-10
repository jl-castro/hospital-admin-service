package com.dharbor.test.service.command.history;

import com.dharbor.test.hospital.api.input.HistoryInput;
import com.dharbor.test.service.exception.DoctorNotFoundException;
import com.dharbor.test.service.exception.PatientNotFoundException;
import com.dharbor.test.service.model.domain.Doctor;
import com.dharbor.test.service.model.domain.History;
import com.dharbor.test.service.model.domain.Patient;
import com.dharbor.test.service.model.repositories.DoctorRepository;
import com.dharbor.test.service.model.repositories.HistoryRepository;
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
public class HistoryCreateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private Long patientId;

    @Setter
    private Long doctorId;

    @Setter
    private HistoryInput input;

    @Getter
    private History history;

    @Getter
    private Patient patient;

    @Getter
    private Doctor doctor;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void execute() {
        patient = validatePatient();
        doctor = validateDoctor();
        history = historyRepository.save(composeHistoryInstance(input));
    }

    private Patient validatePatient() {
        return patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
    }

    private Doctor validateDoctor() {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + doctorId));
    }


    private History composeHistoryInstance(HistoryInput input) {

        History instance = new History();
        instance.setDescription(input.getDescription());
        instance.setPatient(patient);
        instance.setDoctor(doctor);
        instance.setCreatedBy(userId);

        return instance;
    }
}
