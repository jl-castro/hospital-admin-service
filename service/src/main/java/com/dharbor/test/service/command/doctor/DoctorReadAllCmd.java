package com.dharbor.test.service.command.doctor;

import com.dharbor.test.hospital.api.response.DoctorResponse;
import com.dharbor.test.service.model.builder.DoctorResponseBuilder;
import com.dharbor.test.service.model.domain.Doctor;
import com.dharbor.test.service.model.repositories.DoctorRepository;
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
public class DoctorReadAllCmd implements BusinessLogicCommand {

    @Getter
    private List<DoctorResponse> doctorsResponseList;

    @Autowired
    private DoctorRepository repository;

    @Override
    public void execute() {
        doctorsResponseList = new ArrayList<>();
        validateDeleted();
    }

    private void validateDeleted() {
        List<Doctor> doctorList = repository.findAll()
                .stream()
                .filter(doctor -> Boolean.FALSE.equals(doctor.getIsDeleted()))
                .collect(Collectors.toList());
        doctorList.forEach(doctor -> doctorsResponseList.add(DoctorResponseBuilder.getInstance(doctor).build()));
    }
}
