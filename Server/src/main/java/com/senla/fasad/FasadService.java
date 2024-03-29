package com.senla.fasad;

import com.senla.api.fasad.IFasadService;
import com.senla.api.service.IServiceService;
import com.senla.dto.modelDTO.ServiceDTO;
import com.senla.model.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class FasadService implements IFasadService {

    IServiceService serviceService;

    @Autowired
    public FasadService(IServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @Override
    public void save(Service service) {
        serviceService.save(service);
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
    public void deleteService(Integer id) {
        serviceService.deleteService(id);
    }

    @Override
    public void updateService(Service service) {
        serviceService.updateService(service);
    }

    @Override
    public void updateService(Integer id, Service service) {
        serviceService.updateService(service);
    }


}
