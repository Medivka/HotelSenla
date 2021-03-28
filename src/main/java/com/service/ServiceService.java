package com.service;


import com.api.service.IServiceService;
import com.dao.ServiceDao;
import com.exceptions.DaoException;
import com.exceptions.ServiceExeption;
import com.model.Service;
import com.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ServiceService implements IServiceService {

    private final ServiceDao serviceDao;
    private static ServiceService instance;

    private static final Logger LOGGER = Logger.getLogger(ServiceService.class.getName());

    public static ServiceService getInstance() {
        if (instance == null) {
            instance = new ServiceService(ServiceDao.getInstance());
        }
        return instance;
    }

    public ServiceService(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }


    @Override
    public Service findById(Integer id) {
        try {
            Service service = serviceDao.findById(id);
            LOGGER.log(Level.INFO, String.format("Find by Id %s", id));
            if (service == null) {

            }
            return service;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "findById %s failed", id);
            throw new ServiceExeption("findById failed", e);
        }
    }


    @Override
    public List<Service> showAllService() {
        try {
            LOGGER.log(Level.INFO, String.format("showAllService"));
            ArrayList<Service> services = new ArrayList<>(serviceDao.getServiceList());
            return services;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "showAllService failed");
            throw new ServiceExeption("showAllService failed", e);
        }
    }

    @Override
    public Service createService(String name, Integer price) {
        try {
            Service service = new Service(IdGenerator.generateServiceId(), name, price);
            LOGGER.log(Level.INFO, String.format("createService id: %s, name: %s, price: %s", service.getId(), name, price));
            serviceDao.save(service);
            return service;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "createService failed");
            throw new ServiceExeption("createService failed", e);
        }
    }

    @Override
    public void changeServiceName(Integer idService, String name) {
        try {
            LOGGER.log(Level.INFO, String.format("changeServiceName  id: %s, name: %s", idService, name));
            Service service = serviceDao.findById(idService);
            if (service == null) {
                System.out.println("com.service is not found  \n");
            } else
                service.setName(name);
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeServiceName %s  failed", idService);
            throw new ServiceExeption("changeServiceName failed", e);
        }
    }

    @Override
    public void changeServicePrice(Integer idService, Integer price) {
        try {
            LOGGER.log(Level.INFO, String.format("changeServicePrice  id: %s, name: %s", idService, price));
            Service service = serviceDao.findById(idService);
            if (service == null) {
                System.out.println("com.service is not found  \n");
            } else
                service.setPrice(price);
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "changeServicePrice %s  failed", idService);
            throw new ServiceExeption("changeServicePrice failed", e);
        }
    }

    @Override
    public void deleteService(Integer id){
        LOGGER.log(Level.INFO, String.format("delete service %s",id));
        serviceDao.delete(id);
    }

    @Override
    public List sortedByPrice() {
        try {
            LOGGER.log(Level.INFO, String.format("sortedByPrice"));
            ArrayList<Service> services = new ArrayList<>(serviceDao.getServiceList());
            services.stream().sorted(((o1, o2) -> o1.getPrice() - o2.getPrice())).collect(Collectors.toList()).forEach(service -> System.out.println(service));
            return services;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "sortedByPrice failed");
            throw new ServiceExeption("sortedByPrice failed", e);
        }
    }

    @Override
    public void setServiceList(List list) {
        LOGGER.log(Level.INFO, String.format("setServiceList"));
        serviceDao.setServiceList(list);
    }


}
