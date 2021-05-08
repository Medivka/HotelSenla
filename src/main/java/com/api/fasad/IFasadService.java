package com.api.fasad;

import com.model.Service;

import java.util.List;

public interface IFasadService {
    Service findById(Integer idService);

    List<Service> showAllService();

    Service createNewService(String name, Integer price);

    void changeServiceName(Integer idservice, String name);

    void changeServicePrice(Integer idservice, Integer price);

    List<Service> sortedByPrice();

    void setServiceList(List list);

    void deleteService(Service service);

    void updateService(Service service);
}
