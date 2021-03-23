package com.dao;

import com.api.dao.IServiceDao;
import com.exceptions.DaoException;
import com.fasad.FasadService;
import com.model.Service;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements IServiceDao {

    Service service;
    private List<Service> serviceList = new ArrayList<>();


    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }


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
            }
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
            throw e;
        }
    }

}


