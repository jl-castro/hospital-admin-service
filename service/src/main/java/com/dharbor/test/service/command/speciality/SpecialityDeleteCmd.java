package com.dharbor.test.service.command.speciality;

import com.dharbor.test.service.exception.SpecialityNotFoundException;
import com.dharbor.test.service.model.domain.Speciality;
import com.dharbor.test.service.model.repositories.SpecialityRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class SpecialityDeleteCmd implements BusinessLogicCommand {

    @Setter
    private Long specialityId;

    @Getter
    private Speciality speciality;

    @Autowired
    private SpecialityRepository repository;

    @Override
    public void execute() {
        speciality = findSpeciality(specialityId);
        validate();
        speciality = repository.save(softDelete(speciality));
    }

    private Speciality findSpeciality(Long specialityId) {
        return repository.findById(specialityId).orElseThrow(() -> new SpecialityNotFoundException("Speciality not found with id: " + specialityId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(speciality.getIsDeleted())) {
            throw new SpecialityNotFoundException("Speciality not found with id: " + specialityId);
        }
    }

    private Speciality softDelete(Speciality instance) {
        instance.setIsDeleted(true);
        return instance;
    }
}
