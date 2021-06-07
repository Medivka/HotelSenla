package com.senla.api.fasad;



import com.senla.model.Service;

import java.util.List;

public interface IFasadService {
    void save(Service service);

    Service findById(Integer idService);

    List<Service> showAllService();

    Service createNewService(String name, Integer price);

    void changeServiceName(Integer idservice, String name);

    void changeServicePrice(Integer idservice, Integer price);

    List<Service> sortedByPrice();

    void setServiceList(List list);

    void deleteService(Integer id);

    void updateService(Service service);
}
