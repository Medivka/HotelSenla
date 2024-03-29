package com.senla.api.service;


import com.senla.model.Service;

import java.util.List;

public interface IServiceService {

    void updateService(Integer id, Service service);

    void updateService(Service service);

    Service findById(Integer id);

    List showAllService();

    Service createService(String name, Integer price);

    void changeServiceName(Integer idService, String name);

    void changeServicePrice(Integer idService, Integer price);

    void deleteService(Integer id);

    List sortedByPrice();

    void setServiceList(List list);

    void save(Service service);
}
