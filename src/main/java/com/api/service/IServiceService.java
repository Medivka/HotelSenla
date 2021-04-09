package com.api.service;

import com.model.Service;

import java.util.List;

public interface IServiceService {


    void updateService(Service service);

    Service findById(Integer id);
   List showAllService();
    Service createService(String name, Integer price);
    void changeServiceName(Integer idService, String name);
    void changeServicePrice(Integer idService, Integer price);

    void deleteService(Integer id);

    List sortedByPrice();

    void setServiceList(List list);
}
