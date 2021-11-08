package com.dharbor.test.service.controller.speciality;

import com.dharbor.test.service.command.speciality.SpecialityReadAllCmd;
import com.dharbor.test.service.model.domain.Speciality;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * @author Jorge Castro
 */
@Api(
        tags = "Specialities"
)
@RequestMapping(value = "/secure/specialities")
@RequestScope
@RestController
public class SpecialityReadAllController {

    @Autowired
    private SpecialityReadAllCmd specialityReadAllCmd;

    @ApiOperation(
            value = "Read all specialities"
    )
    @GetMapping
    public List<Speciality> getAll() {
        specialityReadAllCmd.execute();
        return specialityReadAllCmd.getSpecialities();
    }

}
