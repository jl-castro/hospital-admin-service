package com.dharbor.test.service.command.history;

import com.dharbor.test.hospital.api.input.HistoryInput;
import com.dharbor.test.service.exception.DoctorNotFoundException;
import com.dharbor.test.service.exception.HistoryNotFoundException;
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

import java.util.Date;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class HistoryUpdateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private Long doctorId;

    @Setter
    private Long patientId;

    @Setter
    private Long historyId;

    @Setter
    private HistoryInput input;

    @Getter
    private History history;

    @Getter
    private Doctor doctor;

    @Getter
    private Patient patient;

    @Autowired
    private HistoryRepository repository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void execute() {
        history = findHistory(historyId);
        patient = validatePatient();
        doctor = validateDoctor();
        validate();
        history = repository.save(updateHistory(history));
    }

    private History findHistory(Long historyId) {
        return repository.findById(historyId).orElseThrow(() -> new HistoryNotFoundException("History not found with id: " + historyId));
    }

    private Patient validatePatient() {
        return patientRepository.findById(patientId).orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
    }

    private Doctor validateDoctor() {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + doctorId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(history.getIsDeleted())) {
            throw new HistoryNotFoundException("History not found with id: " + historyId);
        }
    }

    private History updateHistory(History instance) {
        instance.setDescription(input.getDescription());
        instance.setDoctor(doctor);
        instance.setPatient(patient);
        instance.setUpdatedBy(userId);
        instance.setUpdatedAt(new Date());
        return instance;
    }
}
