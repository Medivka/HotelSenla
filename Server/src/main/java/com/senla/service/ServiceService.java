package com.senla.service;


import com.senla.api.dao.IServiceDao;
import com.senla.api.service.IServiceService;
import com.senla.dao.ServiceDao;
import com.senla.exceptions.DaoException;
import com.senla.exceptions.ServiceExeption;
import com.senla.model.Service;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@Transactional
public class ServiceService implements IServiceService {


    IServiceDao serviceDao;
    @Autowired
    public ServiceService(IServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }
    private static final Logger LOGGER = Logger.getLogger(ServiceService.class.getName());

   @Override
   public void  updateService(Integer id, Service service){
       Service service1 = serviceDao.findById(id);
       service1=service;
       serviceDao.updateService(service1);
   }


    @Override
    public void updateService(Service service) {
        try {
            LOGGER.log(Level.INFO, String.format("update Service"));
            serviceDao.updateService(service);
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, String.format("update Service failed"));
            throw new ServiceExeption("update Service failed", e);
        }
    }

    @Override
    public Service findById(Integer id) {
        try {
            LOGGER.log(Level.INFO, String.format("Find by Id %s", id));
            Service service = serviceDao.findById(id);

            return service;
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "findById failed", e);
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
            LOGGER.log(Level.WARN, "showAllService failed", e);
            throw new ServiceExeption("showAllService failed", e);
        }
    }

    @Override
    public Service createService(String name, Integer price) {
        try {
            Service service = new Service(name, price);
            LOGGER.log(Level.INFO, String.format("createService  name: %s, price: %s", name, price));
            serviceDao.save(service);
            return service;
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "createService failed", e);
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
            LOGGER.log(Level.WARN, "changeServiceName  failed", e);
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
            LOGGER.log(Level.WARN, "changeServicePrice   failed", e);
            throw new ServiceExeption("changeServicePrice failed", e);
        }
    }

    @Override
    public void deleteService(Integer id) {
        try {
            LOGGER.log(Level.INFO, String.format("delete service %s", id));
            serviceDao.delete(serviceDao.findById(id));
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "delete Service  failed", e);
            throw new ServiceExeption("delete Service failed", e);
        }
    }

    @Override
    public List sortedByPrice() {
        try {
            LOGGER.log(Level.INFO, String.format("sortedByPrice"));
            ArrayList<Service> services = new ArrayList<>(serviceDao.getServiceList());
            services.stream().sorted(((o1, o2) -> o1.getPrice() - o2.getPrice())).collect(Collectors.toList()).forEach(service -> System.out.println(service));
            return services;
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "sortedByPrice failed", e);
            throw new ServiceExeption("sortedByPrice failed", e);
        }
    }

    @Override
    public void setServiceList(List list) {
        try {
            LOGGER.log(Level.INFO, String.format("setServiceList"));
            serviceDao.setServiceList(list);
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "set serviceList  failed", e);
            throw new ServiceExeption("set serviceList failed", e);
        }
    }

    @Override
    public void save(Service service) {
        serviceDao.save(service);
        LOGGER.log(Level.INFO, String.format("save service"));
    }

}
