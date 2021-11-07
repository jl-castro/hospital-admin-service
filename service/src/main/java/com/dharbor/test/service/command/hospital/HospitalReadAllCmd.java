package com.dharbor.test.service.command.hospital;

import com.dharbor.test.service.model.domain.Hospital;
import com.dharbor.test.service.model.repositories.HospitalRepository;
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
public class HospitalReadAllCmd implements BusinessLogicCommand {

    @Getter
    private List<Hospital> hospitals;

    @Autowired
    private HospitalRepository repository;

    @Override
    public void execute() {
        hospitals = new ArrayList<>(validateDeleted());
    }

    private List<Hospital> validateDeleted() {
        return repository.findAll()
                .stream()
                .filter(hospital -> Boolean.FALSE.equals(hospital.getIsDeleted()))
                .collect(Collectors.toList());
    }
}
