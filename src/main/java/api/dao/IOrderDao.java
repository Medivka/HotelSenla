package api.dao;

import api.enums.RoomStatus;
import model.*;

import java.util.List;

public interface IOrderDao {



    void     save(Order order);

    void delete(Integer id);

    Order findById(Integer id);

    void writeInFile();

    void readFromFile();
}
