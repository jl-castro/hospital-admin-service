package com.dharbor.test.service.controller.hospital;

import com.dharbor.test.hospital.api.input.HospitalInput;
import com.dharbor.test.hospital.api.response.HospitalResponse;
import com.dharbor.test.service.command.hospital.HospitalCreateCmd;
import com.dharbor.test.service.model.builder.HospitalResponseBuilder;
import com.dharbor.test.service.model.domain.Hospital;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Jorge Castro
 */
@Api(
        tags = "Hospitals"
)
@RequestMapping(value = "/secure/hospitals")
@RequestScope
@RestController
public class HospitalCreateController {

    @Autowired
    private HospitalCreateCmd hospitalCreateCmd;

    @ApiOperation(
            value = "Create a hospital"
    )
    @PostMapping
    public HospitalResponse createHospital(@RequestHeader("User-ID") Long userId  ,@RequestBody HospitalInput input) {
        hospitalCreateCmd.setUserId(userId);
        hospitalCreateCmd.setInput(input);
        hospitalCreateCmd.execute();

        Hospital hospital = hospitalCreateCmd.getHospital();

        return HospitalResponseBuilder.getInstance(hospital).build();
    }
}
