package com.dharbor.test.service.command.hospital;

import com.dharbor.test.hospital.api.input.HospitalInput;

import com.dharbor.test.service.model.domain.Hospital;
import com.dharbor.test.service.model.repositories.HospitalRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class HospitalCreateCmd implements BusinessLogicCommand {

    @Setter
    private Long userId;

    @Setter
    private HospitalInput input;

    @Getter
    private Hospital hospital;

    @Autowired
    private HospitalRepository repository;

    @Override
    public void execute() {
        hospital = repository.save(composeHospitalInstance(input));
    }

    private Hospital composeHospitalInstance(HospitalInput input) {
        Hospital instance = new Hospital();
        instance.setName(input.getName());
        instance.setAddress(input.getAddress());
        instance.setCreatedBy(userId);

        return instance;
    }
}
