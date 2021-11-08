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
public class SpecialityReadOneCmd implements BusinessLogicCommand {

    @Setter
    private Long specialityId;

    @Getter
    private Speciality speciality;

    @Autowired
    private SpecialityRepository repository;

    @Override
    public void execute() {
        speciality = repository.findById(specialityId).orElseThrow(() -> new SpecialityNotFoundException("Speciality not found with id: " + specialityId));
        validate(speciality);
    }

    private void validate(Speciality instance) {
        if (Boolean.TRUE.equals(instance.getIsDeleted())) {
            throw new SpecialityNotFoundException("Speciality not found with id: " + specialityId);
        }
    }
}
