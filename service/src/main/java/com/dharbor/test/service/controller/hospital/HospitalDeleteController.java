package com.dharbor.test.service.controller.hospital;

import com.dharbor.test.service.command.hospital.HospitalDeleteCmd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class HospitalDeleteController {

    @Autowired
    private HospitalDeleteCmd hospitalDeleteCmd;

    @ApiOperation(
            value = "Delete a hospital"
    )
    @DeleteMapping(value = "/{hospitalId}")
    public void deleteById(@PathVariable("hospitalId") Long hospitalId) {
        hospitalDeleteCmd.setHospitalId(hospitalId);
        hospitalDeleteCmd.execute();
    }
}
