package com.dharbor.test.service.model.builder;

import com.dharbor.test.hospital.api.response.DoctorResponse;
import com.dharbor.test.hospital.api.response.SpecialityResponse;
import com.dharbor.test.service.model.domain.Doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Castro
 */
public class DoctorResponseBuilder {

    private DoctorResponse instance;

    private List<SpecialityResponse> specialities;

    public static DoctorResponseBuilder getInstance(Doctor doctor) {
        return (new DoctorResponseBuilder()).setDoctor(doctor);
    }

    private DoctorResponseBuilder() {
        instance = new DoctorResponse();
        specialities = new ArrayList<>();
    }

    private DoctorResponseBuilder setDoctor(Doctor doctor) {

        instance.setDoctorId(doctor.getId());
        instance.setName(doctor.getName());
        instance.setAddress(doctor.getAddress());
        instance.setLastName(doctor.getLastName());
        instance.setBirthday(doctor.getBirthday());
        instance.setProfileId(doctor.getProfileid());
        instance.setHospitalId(doctor.getHospital().getId());
        instance.setIsDeleted(doctor.getIsDeleted());
        instance.setCreatedAt(doctor.getCreatedAt());
        instance.setUpdatedAt(doctor.getUpdatedAt());
        instance.setUpdatedBy(doctor.getUpdatedBy());
        instance.setCreatedBy(doctor.getCreatedBy());
        getSpecialistResponse(doctor);

        return this;
    }

    private void getSpecialistResponse(Doctor doctor) {
        doctor.getSpecialities().forEach(speciality ->
                specialities.add(SpecialityResponseBuilder.getInstance(speciality).build())
        );
    }


    public DoctorResponse build() {
        instance.setSpecialities(specialities);

        return instance;
    }

}
