package com.dharbor.test.service.model.builder;

import com.dharbor.test.hospital.api.response.SpecialityResponse;
import com.dharbor.test.service.model.domain.Speciality;

/**
 * @author Jorge Castro
 */
public class SpecialityResponseBuilder {
    private SpecialityResponse instance;

    public static SpecialityResponseBuilder getInstance(Speciality speciality) {
        return (new SpecialityResponseBuilder()).setSpeciality(speciality);
    }

    private SpecialityResponseBuilder() {
        instance = new SpecialityResponse();
    }

    private SpecialityResponseBuilder setSpeciality(Speciality speciality) {

        instance.setSpecialityId(speciality.getId());
        instance.setName(speciality.getName());
        instance.setDescription(speciality.getDescription());
        instance.setAvatarId(speciality.getAvatarId());
        instance.setIsDeleted(speciality.getIsDeleted());
        instance.setCreatedAt(speciality.getCreatedAt());
        instance.setUpdatedAt(speciality.getUpdatedAt());
        instance.setCreatedBy(speciality.getCreatedBy());
        instance.setUpdatedBy(speciality.getUpdatedBy());

        return this;
    }

    public SpecialityResponse build() {
        return instance;
    }
}
