package com.dharbor.test.service.command.speciality;

import com.dharbor.test.hospital.api.input.SpecialityInput;
import com.dharbor.test.service.exception.SpecialityNotFoundException;
import com.dharbor.test.service.model.domain.Speciality;
import com.dharbor.test.service.model.repositories.SpecialityRepository;
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
public class SpecialityUpdateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private Long specialityId;

    @Setter
    private SpecialityInput input;

    @Getter
    private Speciality speciality;

    @Autowired
    private SpecialityRepository repository;

    @Override
    public void execute() {
        speciality = findSpeciality(specialityId);
        validate();
        speciality = repository.save(updateSpeciality(speciality));
    }

    private Speciality findSpeciality(Long specialityId) {
        return repository.findById(specialityId).orElseThrow(() -> new SpecialityNotFoundException("Speciality not found with id: " + specialityId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(speciality.getIsDeleted())) {
            throw new SpecialityNotFoundException("Speciality not found with id: " + specialityId);
        }
    }

    private Speciality updateSpeciality(Speciality instance) {
        instance.setName(input.getName());
        instance.setDescription(input.getDescription());
        instance.setAvatarId(input.getAvatarId());
        instance.setHospitalId(input.getHospitalId());
        instance.setUpdatedBy(userId);
        instance.setUpdatedAt(new Date());
        return instance;
    }
}
