package com.dharbor.test.service.command.speciality;

import com.dharbor.test.hospital.api.input.SpecialityInput;
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
public class SpecialityCreateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private SpecialityInput input;

    @Getter
    private Speciality speciality;

    @Autowired
    private SpecialityRepository repository;

    @Override
    public void execute() {
        speciality = repository.save(composeSpecialityInstance(input));
    }

    private Speciality composeSpecialityInstance(SpecialityInput input) {
        Speciality instance = new Speciality();
        instance.setName(input.getName());
        instance.setDescription(input.getDescription());
        instance.setAvatarId(input.getAvatarId());
        instance.setCreatedBy(userId);

        return instance;
    }
}
