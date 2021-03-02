package dao;

import api.dao.IServiceDao;
import exceptions.DaoException;
import model.Guest;
import model.Service;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements IServiceDao {

    Service service;
    private List<Service> serviceList = new ArrayList<>();
    private static ServiceDao instance;

    private ServiceDao() {
    }

    public static ServiceDao getInstance() {
        if (instance == null) {
            instance = new ServiceDao();
        }
        return instance;
    }


    public List<Service> getServiceList() {
        return new ArrayList<>(serviceList);
    }


    @Override
    public void save(Service service) {
        serviceList.add(service);
    }

    @Override
    public void delete(Integer id) {
        try {
            if (id < serviceList.size() + 1) {
                for (int i = 0; i < serviceList.size(); i++) {
                    Service service = serviceList.get(i);
                    if (id.equals(service.getId())) {
                        serviceList.remove(i);
                    }
                }
            } else System.out.println("service not found");
        } catch (DaoException e) {
            throw e;
        }
    }

    @Override
    public Service findById(Integer id) {
        try {
            for (int i = 0; i < serviceList.size(); i++) {
                Service service = serviceList.get(i);
                if (id.equals(service.getId())) {
                    return service;
                }
            }
            return service;
        } catch (DaoException e) {
            throw  e;
        }
    }
}


