package api.dao;

import dao.ServiceDao;
import model.Service;

public interface IServiceDao {


    void save(Service service);

    void delete(Integer id);






    Service findById(Integer id);

    Service update(Integer id, String name, Integer price);
}

