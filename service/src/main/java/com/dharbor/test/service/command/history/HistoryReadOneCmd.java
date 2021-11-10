package com.dharbor.test.service.command.history;

import com.dharbor.test.service.exception.HistoryNotFoundException;
import com.dharbor.test.service.model.domain.History;
import com.dharbor.test.service.model.repositories.HistoryRepository;
import com.jatun.open.tools.blcmd.annotations.SynchronousExecution;
import com.jatun.open.tools.blcmd.core.BusinessLogicCommand;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jorge Castro
 */
@SynchronousExecution
public class HistoryReadOneCmd implements BusinessLogicCommand {

    @Setter
    private Long historyId;

    @Getter
    private History history;

    @Autowired
    private HistoryRepository repository;

    @Override
    public void execute() {
        history = repository.findById(historyId).orElseThrow(() -> new HistoryNotFoundException("History not found with id: " + historyId));
        validate(history);
    }

    private void validate(History instance) {
        if (Boolean.TRUE.equals(instance.getIsDeleted())) {
            throw new HistoryNotFoundException("History not found with id: " + historyId);
        }
    }
}
