package com.dharbor.test.service.controller.history;

import com.dharbor.test.hospital.api.input.HistoryInput;
import com.dharbor.test.hospital.api.response.HistoryResponse;
import com.dharbor.test.service.command.history.HistoryCreateCmd;
import com.dharbor.test.service.model.builder.HistoryResponseBuilder;
import com.dharbor.test.service.model.domain.History;
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
public class HistoryCreateController {

    @Autowired
    private HistoryCreateCmd historyCreateCmd;

    @ApiOperation(
            value = "Create a history"
    )
    @PostMapping
    public HistoryResponse createHistory(@RequestHeader("User-ID") Long userId,
                                         @RequestHeader("doctorId") Long doctorId,
                                         @RequestHeader("patientId") Long patientId,
                                         @RequestBody HistoryInput input) {
        historyCreateCmd.setUserId(userId);
        historyCreateCmd.setDoctorId(doctorId);
        historyCreateCmd.setPatientId(patientId);
        historyCreateCmd.setInput(input);
        historyCreateCmd.execute();

        History history = historyCreateCmd.getHistory();

        return HistoryResponseBuilder.getInstance(history).build();
    }
}
