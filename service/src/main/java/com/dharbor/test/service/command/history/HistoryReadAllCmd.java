package com.dharbor.test.service.command.history;

import com.dharbor.test.hospital.api.response.HistoryResponse;
import com.dharbor.test.service.model.builder.HistoryResponseBuilder;
import com.dharbor.test.service.model.domain.History;
import com.dharbor.test.service.model.repositories.HistoryRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class HistoryReadAllCmd implements BusinessLogicCommand {

    @Getter
    private List<HistoryResponse> histories;

    @Autowired
    private HistoryRepository repository;

    @Override
    public void execute() {
        histories = new ArrayList<>();
        validateDeleted();
    }

    private void validateDeleted() {
        List<History> historyList = repository.findAll()
                .stream()
                .filter(history -> Boolean.FALSE.equals(history.getIsDeleted()))
                .collect(Collectors.toList());
        historyList.forEach(history -> histories.add(HistoryResponseBuilder.getInstance(history).build()));
    }
}
