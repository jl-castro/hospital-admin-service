package com.dharbor.test.service.controller.history;

import com.dharbor.test.hospital.api.input.HistoryInput;
import com.dharbor.test.hospital.api.response.HistoryResponse;
import com.dharbor.test.service.command.history.HistoryUpdateCmd;
import com.dharbor.test.service.model.builder.HistoryResponseBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Jorge Castro
 */
@Api(
        tags = "Histories"
)
@RequestMapping(value = "/secure/histories")
@RequestScope
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HistoryUpdateController {

    @Autowired
    private HistoryUpdateCmd historyUpdateCmd;

    @ApiOperation(
            value = "Update a history"
    )
    @PutMapping(value = "/{historyId}")
    public HistoryResponse updateHistory(@RequestHeader("User-ID") Long userId,
                                         @PathVariable("historyId") Long historyId,
                                         @RequestHeader("doctorId") Long doctorId,
                                         @RequestHeader("patientId") Long patientId,
                                         @RequestBody HistoryInput input) {
        historyUpdateCmd.setUserId(userId);
        historyUpdateCmd.setHistoryId(historyId);
        historyUpdateCmd.setDoctorId(doctorId);
        historyUpdateCmd.setPatientId(patientId);
        historyUpdateCmd.setInput(input);
        historyUpdateCmd.execute();

        return HistoryResponseBuilder.getInstance(historyUpdateCmd.getHistory())
                .build();
    }
}
