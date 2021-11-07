package com.dharbor.test.service.command.hospital;

import com.dharbor.test.service.exception.HospitalNotFoundException;
import com.dharbor.test.service.model.domain.Hospital;
import com.dharbor.test.service.model.repositories.HospitalRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class HospitalDeleteCmd implements BusinessLogicCommand {

    @Setter
    private Long hospitalId;

    @Getter
    private Hospital hospital;

    @Autowired
    private HospitalRepository repository;

    @Override
    public void execute() {
        hospital = findHospital(hospitalId);
        validate();
        hospital = repository.save(softDelete(hospital));
    }

    private Hospital findHospital(Long hospitalId) {
        return repository.findById(hospitalId).orElseThrow(() -> new HospitalNotFoundException("Hospital not found with id: " + hospitalId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(hospital.getIsDeleted())) {
            throw new HospitalNotFoundException("Hospital not found with id: " + hospitalId);
        }
    }

    private Hospital softDelete(Hospital instance) {
        instance.setIsDeleted(true);
        return instance;
    }
}
