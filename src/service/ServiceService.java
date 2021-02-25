package service;


import api.service.IServiceService;
import dao.GuestDao;
import dao.ServiceDao;
import model.Service;
import util.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceService implements IServiceService {

    private final ServiceDao serviceDao;
    private static ServiceService instance;
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
        return service;
    }


    @Override
    public List<Service> showAllService() {
        ArrayList<Service> services = new ArrayList<>(serviceDao.getServiceList());
       return services;
    }

    @Override
    public Service createService(String name, Integer price) {
        Service service = new Service(IdGenerator.generateServiceId(), name, price);
        serviceDao.save(service);
        return service;
    }

    @Override
    public void changeServiceName(Integer idService, String name) {
        Service service = serviceDao.findById(idService);
        service.setName(name);
    }

    @Override
    public void changeServicePrice(Integer idService, Integer price) {
        Service service = serviceDao.findById(idService);
        service.setPrice(price);
    }

    @Override
    public List sortedByPrice() {
        ArrayList<Service> services = new ArrayList<>(serviceDao.getServiceList());
        services.stream().sorted(((o1, o2) -> o1.getPrice() - o2.getPrice())).collect(Collectors.toList()).forEach(service -> System.out.println(service));
        return services;
    }
}
