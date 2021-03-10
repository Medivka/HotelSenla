package api.dao;

import model.Guest;

import java.util.List;

public interface IGuestDao {


    void     delete(Integer id);

    void    save(Guest guest);



    Guest findById(Integer id);


    Guest update(Integer id, String name, Integer age);
}
