package com.dharbor.test.service.controller.history;

import com.dharbor.test.hospital.api.response.HistoryResponse;
import com.dharbor.test.service.command.history.HistoryReadOneCmd;
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
public class HistoryReadOneController {

    @Autowired
    private HistoryReadOneCmd historyReadOneCmd;

    @ApiOperation(
            value = "Read a history"
    )
    @GetMapping(value = "/{historyId}")
    public HistoryResponse getById(@PathVariable("historyId") Long historyId) {
        historyReadOneCmd.setHistoryId(historyId);
        historyReadOneCmd.execute();
        History history = historyReadOneCmd.getHistory();

        return HistoryResponseBuilder.getInstance(history).build();
    }
}
