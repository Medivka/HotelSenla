package com.api.dao;

import com.model.Service;

import java.util.List;

public interface IServiceDao {

    void setServiceList(List<Service> serviceList);

    List<Service> getServiceList();

    void save(Service service);
    void delete(Service service);
    Service findById(Integer id);

    void updateService(Service service);
}

