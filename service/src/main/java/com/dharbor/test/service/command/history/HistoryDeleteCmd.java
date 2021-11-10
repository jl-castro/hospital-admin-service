package com.dharbor.test.service.command.history;

import com.dharbor.test.service.exception.HistoryNotFoundException;
import com.dharbor.test.service.exception.HospitalNotFoundException;
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
public class HistoryDeleteCmd implements BusinessLogicCommand {

    @Setter
    private Long historyId;

    @Getter
    private History history;

    @Autowired
    private HistoryRepository repository;

    @Override
    public void execute() {
        history = findHistory(historyId);
        validate();
        history = repository.save(softDelete(history));
    }

    private History findHistory(Long historyId) {
        return repository.findById(historyId).orElseThrow(() -> new HistoryNotFoundException("History not found with id: " + historyId));
    }

    private void validate() {
        if (Boolean.TRUE.equals(history.getIsDeleted())) {
            throw new HistoryNotFoundException("History not found with id: " + historyId);
        }
    }

    private History softDelete(History instance) {
        instance.setIsDeleted(true);
        return instance;
    }
}
