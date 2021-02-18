package api.service;

import model.Service;

import java.util.List;

public interface IServiceService {


    Service findById(Integer id);

    void showAllService();

    Service createService(String name, Integer price);

    void changeServiceName(Integer idService, String name);

    void changeServicePrice(Integer idService, Integer price);

    List sortedByPrice();
}
