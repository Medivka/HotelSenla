package com.fasad;

import com.model.Service;
import com.service.ServiceService;

import java.util.List;

public class FasadService {
    private static ServiceService serviceService = ServiceService.getInstance();
    private static FasadService instance;

    public static FasadService getInstance() {
        if (instance == null) {
            instance = new FasadService();
        }
        return instance;
    }

    public Service findById(Integer idService) {
        return serviceService.findById(idService);
    }

    public List<Service> showAllService() {
        return serviceService.showAllService();
    }

    public Service createNewService(String name, Integer price) {
        return serviceService.createService(name, price);
    }

    public void changeServiceName(Integer idservice, String name) {
        serviceService.changeServiceName(idservice, name);
    }

    public void changeServicePrice(Integer idservice, Integer price) {
        serviceService.changeServicePrice(idservice, price);
    }

    public List<Service> sortedByPrice() {
        return serviceService.sortedByPrice();
    }

    public void setServiceList(List list) {
        serviceService.setServiceList(list);
    }


    public void deleteService(Integer id){
        serviceService.deleteService(id);
    }
    public void updateService(Service service){serviceService.updateService(service);}



}
