package com.fasad;

import com.api.fasad.IFasadService;
import com.model.Service;
import com.service.ServiceService;

import java.util.List;

public class FasadService implements IFasadService {
    private static ServiceService serviceService = ServiceService.getInstance();
    private static FasadService instance;

    public static FasadService getInstance() {
        if (instance == null) {
            instance = new FasadService();
        }
        return instance;
    }

    @Override
    public Service findById(Integer idService) {
        return serviceService.findById(idService);
    }

    @Override
    public List<Service> showAllService() {
        return serviceService.showAllService();
    }

    @Override
    public Service createNewService(String name, Integer price) {
        return serviceService.createService(name, price);
    }

    @Override
    public void changeServiceName(Integer idservice, String name) {
        serviceService.changeServiceName(idservice, name);
    }

    @Override
    public void changeServicePrice(Integer idservice, Integer price) {
        serviceService.changeServicePrice(idservice, price);
    }

    @Override
    public List<Service> sortedByPrice() {
        return serviceService.sortedByPrice();
    }

    @Override
    public void setServiceList(List list) {
        serviceService.setServiceList(list);
    }

    @Override
    public void deleteService(Service service) {
        serviceService.deleteService(service);
    }

    @Override
    public void updateService(Service service) {
        serviceService.updateService(service);
    }


}
