package com.api.dao;

import com.model.History;

public interface IHistoryDao {
    void save(History history);

    History findById(Integer id);

    void delete(Integer id);
}
