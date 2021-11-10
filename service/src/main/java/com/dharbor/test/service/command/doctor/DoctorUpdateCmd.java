package com.dharbor.test.service.command.doctor;

import com.dharbor.test.hospital.api.input.DoctorInput;
import com.dharbor.test.service.exception.DoctorNotFoundException;
import com.dharbor.test.service.exception.HospitalNotFoundException;
import com.dharbor.test.service.exception.SpecialityNotFoundException;
import com.dharbor.test.service.model.domain.Doctor;
import com.dharbor.test.service.model.domain.Hospital;
import com.dharbor.test.service.model.domain.Speciality;
import com.dharbor.test.service.model.repositories.DoctorRepository;
import com.dharbor.test.service.model.repositories.HospitalRepository;
import com.dharbor.test.service.model.repositories.SpecialityRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class DoctorUpdateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private Long doctorId;

    @Setter
    private Long hospitalId;

    @Setter
    private DoctorInput input;

    @Getter
    private Doctor doctor;

    @Getter
    private List<Speciality> specialities;

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public void execute() {
        doctor = findDoctor(doctorId);
        validateDoctor();
        validateSpecialities();
        Hospital hospital = findHospital(hospitalId);
        doctor = repository.save(updateDoctor(doctor, hospital));
    }

    private Doctor findDoctor(Long doctorId) {
        return repository.findById(doctorId).orElseThrow(() -> new DoctorNotFoundException("Patient not found with id: " + doctorId));
    }

    private void validateIsDeleted(Speciality instance) {
        if (Boolean.TRUE.equals(instance.getIsDeleted())) {
            throw new SpecialityNotFoundException("Speciality not found with id: " + instance.getId());
        }
    }

    private void validateDoctor() {
        if (Boolean.TRUE.equals(doctor.getIsDeleted())) {
            throw new DoctorNotFoundException("Patient not found with id: " + doctorId);
        }
    }

    private Hospital findHospital(Long hospitalId) {
        return hospitalRepository.findById(hospitalId).orElseThrow(() -> new HospitalNotFoundException("Hospital not found with id: " + hospitalId));
    }

    private void validateSpecialities() {
        specialities = new ArrayList<>();
        List<String> specialityIds = input.getSpecialityIds();
        specialityIds.forEach(id -> {
            Speciality speciality = specialityRepository.findById(Long.parseLong(id)).orElseThrow(() -> new SpecialityNotFoundException("Speciality not found with id: " + id));
            validateIsDeleted(speciality);
            specialities.add(speciality);
        });
    }

    private Doctor updateDoctor(Doctor instance, Hospital hospital) {
        instance.setName(input.getName());
        instance.setLastName(input.getLastName());
        instance.setAddress(input.getAddress());
        instance.setProfileid(input.getProfileId());
        instance.setBirthday(input.getBirthday());
        instance.setSpecialities(specialities);
        instance.setHospital(hospital);
        instance.setUpdatedBy(userId);
        instance.setUpdatedAt(new Date());
        return instance;
    }

}
