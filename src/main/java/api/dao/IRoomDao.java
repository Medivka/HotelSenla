package api.dao;

import model.Room;
import api.enums.RoomStatus;

import java.util.List;

public interface IRoomDao {

    void delete(Integer id);
    void     save(Room room);
    Room findById(Integer id);
}
