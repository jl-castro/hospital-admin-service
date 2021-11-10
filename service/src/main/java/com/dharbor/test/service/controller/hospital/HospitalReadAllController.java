package com.dharbor.test.service.controller.hospital;

import com.dharbor.test.service.command.hospital.HospitalReadAllCmd;
import com.dharbor.test.service.model.domain.Hospital;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

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
public class HospitalReadAllController {

    @Autowired
    private HospitalReadAllCmd hospitalReadAllCmd;

    @ApiOperation(
            value = "Read all hospitals"
    )
    @GetMapping
    public List<Hospital> getAll() {
        hospitalReadAllCmd.execute();
        return hospitalReadAllCmd.getHospitals();
    }

}
