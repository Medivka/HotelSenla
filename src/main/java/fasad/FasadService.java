package fasad;

import api.service.IRoomService;
import model.Service;
import service.RoomService;
import service.ServiceService;

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

    public Service findByID(Integer idservice) {
        return serviceService.findById(idservice);
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

}
