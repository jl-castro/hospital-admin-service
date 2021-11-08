package com.dharbor.test.service.model.builder;

import com.dharbor.test.hospital.api.response.PatientResponse;
import com.dharbor.test.service.model.domain.Patient;

/**
 * @author Jorge Castro
 */
public class PatientResponseBuilder {
    private PatientResponse instance;

    public static PatientResponseBuilder getInstance(Patient patient) {
        return (new PatientResponseBuilder()).setPatient(patient);
    }

    private PatientResponseBuilder() {
        instance = new PatientResponse();
    }

    private PatientResponseBuilder setPatient(Patient patient) {

        instance.setPatientId(patient.getId());
        instance.setName(patient.getName());
        instance.setLastName(patient.getLastName());
        instance.setAddress(patient.getAddress());
        instance.setBirthday(patient.getBirthday());
        instance.setIsDeleted(patient.getIsDeleted());
        instance.setCreatedAt(patient.getCreatedAt());
        instance.setUpdatedAt(patient.getUpdatedAt());
        instance.setCreatedBy(patient.getCreatedBy());
        instance.setUpdatedBy(patient.getUpdatedBy());

        return this;
    }

    public PatientResponse build() {
        return instance;
    }
}
