package com.dharbor.test.service.command.doctor;

import com.dharbor.test.service.exception.DoctorNotFoundException;
import com.dharbor.test.service.model.domain.Doctor;
import com.dharbor.test.service.model.repositories.DoctorRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class DoctorDeleteCmd implements BusinessLogicCommand {

    @Setter
    private Long doctorId;

    @Getter
    private Doctor doctor;

    @Autowired
    private DoctorRepository repository;

    @Override
    public void execute() {
        doctor = findDoctor(doctorId);
        validate();
        doctor = repository.save(softDelete(doctor));
    }

    private Doctor findDoctor(Long doctorId) {
        return repository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + doctorId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(doctor.getIsDeleted())) {
            throw new DoctorNotFoundException("Doctor not found with id: " + doctorId);
        }
    }

    private Doctor softDelete(Doctor instance) {
        instance.setIsDeleted(true);
        return instance;
    }
}
