package com.dharbor.test.service.model.builder;

import com.dharbor.test.hospital.api.response.HistoryResponse;
import com.dharbor.test.service.model.domain.History;

/**
 * @author Jorge Castro
 */
public class HistoryResponseBuilder {
    private HistoryResponse instance;

    public static HistoryResponseBuilder getInstance(History history) {
        return (new HistoryResponseBuilder()).setHistory(history);
    }

    private HistoryResponseBuilder() {
        instance = new HistoryResponse();
    }

    private HistoryResponseBuilder setHistory(History history) {

        instance.setHistoryId(history.getId());
        instance.setDescription(history.getDescription());
        instance.setIsDeleted(history.getIsDeleted());
        instance.setCreatedAt(history.getCreatedAt());
        instance.setUpdatedAt(history.getUpdatedAt());
        instance.setCreatedBy(history.getCreatedBy());
        instance.setUpdatedBy(history.getUpdatedBy());

        return this;
    }

    public HistoryResponse build() {
        return instance;
    }
}
