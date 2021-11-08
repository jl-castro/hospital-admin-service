package com.dharbor.test.service.model.builder;

import com.dharbor.test.hospital.api.response.HospitalResponse;
import com.dharbor.test.service.model.domain.Hospital;

/**
 * @author Jorge Castro
 */
public class HospitalResponseBuilder {
    private HospitalResponse instance;

    public static HospitalResponseBuilder getInstance(Hospital hospital) {
        return (new HospitalResponseBuilder()).setHospital(hospital);
    }

    private HospitalResponseBuilder() {
        instance = new HospitalResponse();
    }

    private HospitalResponseBuilder setHospital(Hospital hospital) {

        instance.setHospitalId(hospital.getId());
        instance.setName(hospital.getName());
        instance.setAddress(hospital.getAddress());
        instance.setIsDeleted(hospital.getIsDeleted());
        instance.setCreatedAt(hospital.getCreatedAt());
        instance.setUpdatedAt(hospital.getUpdatedAt());
        instance.setCreatedBy(hospital.getCreatedBy());
        instance.setUpdatedBy(hospital.getUpdatedBy());

        return this;
    }

    public HospitalResponse build() {
        return instance;
    }
}
