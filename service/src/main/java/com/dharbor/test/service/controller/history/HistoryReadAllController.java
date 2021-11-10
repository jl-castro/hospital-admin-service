package com.dharbor.test.service.controller.history;

import com.dharbor.test.hospital.api.response.HistoryResponse;
import com.dharbor.test.service.command.history.HistoryReadAllCmd;
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
        tags = "Histories"
)
@RequestMapping(value = "/secure/histories")
@RequestScope
@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class HistoryReadAllController {

    @Autowired
    private HistoryReadAllCmd historyReadAllCmd;

    @ApiOperation(
            value = "Read all histories"
    )
    @GetMapping
    public List<HistoryResponse> getAll() {
        historyReadAllCmd.execute();
        return historyReadAllCmd.getHistories();
    }

}
