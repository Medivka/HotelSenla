package com.api.dao;

import com.model.Service;

public interface IServiceDao {

    void save(Service service);
    void delete(Integer id);
    Service findById(Integer id);

    void updateService(Service service);
}

