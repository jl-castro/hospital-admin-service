package com.dharbor.test.service.command.doctor;

import com.dharbor.test.hospital.api.input.DoctorInput;
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
import java.util.List;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class DoctorCreateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private Long hospitalId;

    @Setter
    private DoctorInput input;

    @Getter
    private Doctor doctor;

    @Getter
    private List<Speciality> specialities;

    @Getter
    private List<String> specialityIds;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Override
    public void execute() {
        validateSpecialities();
        Hospital hospital = findHospital(hospitalId);
        doctor = doctorRepository.save(composeDoctorsInstance(input, hospital));
    }

    private void validateSpecialities() {
        specialities = new ArrayList<>();
        specialityIds = input.getSpecialityIds();
        specialityIds.forEach(id -> {
            Speciality speciality = specialityRepository.findById(Long.parseLong(id)).orElseThrow(() -> new SpecialityNotFoundException("Speciality not found with id: " + id));
            validateIsDeleted(speciality);
            specialities.add(speciality);
        });
    }

    private void validateIsDeleted(Speciality instance) {
        if (Boolean.TRUE.equals(instance.getIsDeleted())) {
            throw new SpecialityNotFoundException("Speciality not found with id: " + instance.getId());
        }
    }

    private Hospital findHospital(Long hospitalId) {
        return hospitalRepository.findById(hospitalId).orElseThrow(() -> new HospitalNotFoundException("Hospital not found with id: " + hospitalId));
    }

    private Doctor composeDoctorsInstance(DoctorInput input, Hospital hospital) {

        Doctor instance = new Doctor();
        instance.setName(input.getName());
        instance.setLastName(input.getLastName());
        instance.setAddress(input.getAddress());
        instance.setBirthday(input.getBirthday());
        instance.setProfileid(input.getProfileId());
        instance.setSpecialities(specialities);
        instance.setHospital(hospital);

        instance.setCreatedBy(userId);

        return instance;
    }
}
