package com.dharbor.test.service.controller.hospital;

import com.dharbor.test.hospital.api.response.HospitalResponse;
import com.dharbor.test.service.command.hospital.HospitalReadOneCmd;
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
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HospitalReadOneController {

    @Autowired
    private HospitalReadOneCmd hospitalReadOneCmd;

    @ApiOperation(
            value = "Read a hospital"
    )
    @GetMapping(value = "/{hospitalId}")
    public HospitalResponse getById(@PathVariable("hospitalId") Long hospitalId) {
        hospitalReadOneCmd.setHospitalId(hospitalId);
        hospitalReadOneCmd.execute();
        Hospital hospital = hospitalReadOneCmd.getHospital();

        return HospitalResponseBuilder.getInstance(hospital).build();
    }
}
