package com.dharbor.test.service.command.hospital;

import com.dharbor.test.hospital.api.input.HospitalInput;
import com.dharbor.test.service.exception.HospitalNotFoundException;
import com.dharbor.test.service.model.domain.Hospital;
import com.dharbor.test.service.model.repositories.HospitalRepository;
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
public class HospitalUpdateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private Long hospitalId;

    @Setter
    private HospitalInput input;

    @Getter
    private Hospital hospital;

    @Autowired
    private HospitalRepository repository;

    @Override
    public void execute() {
        hospital = findHospital(hospitalId);
        validate();
        hospital = repository.save(updateHospital(hospital));
    }

    private Hospital findHospital(Long hospitalId) {
        return repository.findById(hospitalId).orElseThrow(() -> new HospitalNotFoundException("Hospital not found with id: " + hospitalId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(hospital.getIsDeleted())) {
            throw new HospitalNotFoundException("Hospital not found with id: " + hospitalId);
        }
    }

    private Hospital updateHospital(Hospital instance) {
        instance.setName(instance.getName());
        instance.setAddress(instance.getAddress());
        instance.setUpdatedBy(userId);
        instance.setUpdatedAt(new Date());
        return instance;
    }
}
