package com.dharbor.test.service.command.speciality;

import com.dharbor.test.hospital.api.response.SpecialityResponse;
import com.dharbor.test.service.model.builder.SpecialityResponseBuilder;
import com.dharbor.test.service.model.domain.Speciality;
import com.dharbor.test.service.model.repositories.SpecialityRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class SpecialityReadAllCmd implements BusinessLogicCommand {

    @Getter
    private List<SpecialityResponse> specialities;

    @Autowired
    private SpecialityRepository repository;

    @Override
    public void execute() {
        specialities = new ArrayList<>();
        validateDeleted();
    }

    private void validateDeleted() {
        List<Speciality> specialityList = repository.findAll()
                .stream()
                .filter(speciality -> Boolean.FALSE.equals(speciality.getIsDeleted()))
                .collect(Collectors.toList());
        specialityList.forEach(speciality -> specialities.add(SpecialityResponseBuilder.getInstance(speciality).build()));
    }
}
