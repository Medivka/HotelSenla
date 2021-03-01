package service;


import api.service.IServiceService;
import dao.GuestDao;
import dao.ServiceDao;
import model.Service;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ServiceService implements IServiceService {

    private final ServiceDao serviceDao;
    private static ServiceService instance;

    private static final Logger LOGGER=Logger.getLogger(ServiceService.class.getName());

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
        Service service = serviceDao.findById(id);
        LOGGER.log(Level.INFO,String.format("Find by Id %s", id));
        if (service==null){
            System.out.println("service is not found  \n");
        }
        return service;
    }


    @Override
    public List<Service> showAllService() {
        LOGGER.log(Level.INFO,String.format("showAllService"));
        ArrayList<Service> services = new ArrayList<>(serviceDao.getServiceList());
       return services;
    }

    @Override
    public Service createService(String name, Integer price) {

        Service service = new Service(IdGenerator.generateServiceId(), name, price);
        LOGGER.log(Level.INFO,String.format("createService id: %s, name: %s, price: %s", service.getId(),name,price));
        serviceDao.save(service);
        return service;
    }

    @Override
    public void changeServiceName(Integer idService, String name) {
        LOGGER.log(Level.INFO,String.format("changeServiceName  id: %s, name: %s", idService,name));
        Service service = serviceDao.findById(idService);
        if (service==null){
            System.out.println("service is not found  \n");
        }else
        service.setName(name);
    }

    @Override
    public void changeServicePrice(Integer idService, Integer price) {
        LOGGER.log(Level.INFO,String.format("changeServicePrice  id: %s, name: %s", idService,price));
        Service service = serviceDao.findById(idService);
        if (service==null){
            System.out.println("service is not found  \n");
        }else
        service.setPrice(price);
    }

    @Override
    public List sortedByPrice() {
        LOGGER.log(Level.INFO,String.format("sortedByPrice"));
        ArrayList<Service> services = new ArrayList<>(serviceDao.getServiceList());
        services.stream().sorted(((o1, o2) -> o1.getPrice() - o2.getPrice())).collect(Collectors.toList()).forEach(service -> System.out.println(service));
        return services;
    }
}
