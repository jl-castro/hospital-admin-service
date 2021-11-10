package com.dharbor.test.service.controller.history;

import com.dharbor.test.service.command.history.HistoryDeleteCmd;
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
public class HistoryDeleteController {

    @Autowired
    private HistoryDeleteCmd historyDeleteCmd;

    @ApiOperation(
            value = "Delete a history"
    )
    @DeleteMapping(value = "/{historyId}")
    public void deleteById(@PathVariable("historyId") Long historyId) {
        historyDeleteCmd.setHistoryId(historyId);
        historyDeleteCmd.execute();
    }
}
