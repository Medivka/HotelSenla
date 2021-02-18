package dao;

import api.dao.IServiceDao;
import model.Guest;
import model.Service;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements IServiceDao {

    Service service;
    private List<Service> serviceList = new ArrayList<>();

    public List<Service> getServiceList() {
        return new ArrayList<>(serviceList);
    }


    @Override
    public void save(Service service) {
        serviceList.add(service);
    }

    @Override
    public void delete(Integer id) {
        if (id < serviceList.size() + 1) {
            for (int i = 0; i < serviceList.size(); i++) {
                Service service = serviceList.get(i);
                if (id.equals(service.getId())) {
                    serviceList.remove(i);
                }
            }
        } else System.out.println("service not found");
    }

    @Override
    public Service findById(Integer id) {
        for (int i = 0; i < serviceList.size(); i++) {
            Service service = serviceList.get(i);
            if (id.equals(service.getId())) {
                return service;
            } else service = null;
        }
        return service;
    }

    @Override
    public Service update(Integer id, String name, Integer price) {
        for (int i = 0; i < serviceList.size(); i++) {
            Service service = serviceList.get(i);

            if (id.equals(service.getId())) {
                service.setName(name);
                service.setPrice(price);
                return service;
            } else service = null;
        }
        return service;
    }
}


