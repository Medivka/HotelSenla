package fasad;

import api.enums.RoomStatus;
import api.service.IRoomService;
import model.Room;
import service.RoomService;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class FasadRoom {
    private static IRoomService roomService = RoomService.getInstance();
    private static FasadRoom instance;

    public static FasadRoom getInstance() {
        if (instance == null) {
            instance = new FasadRoom();
        }
        return instance;
    }

    public List<Room> showAllRoom() {
        return roomService.showAllRoom();
    }

    public Room findById(Integer IdRoom) {
        return roomService.findById(IdRoom);
    }

    public Room createRoom(RoomStatus roomStatus, Integer copacity, Integer price, Integer stars) {   return roomService.createRoom(roomStatus, copacity, price, stars);    }
    public void changeRoomStars(Integer IdRoom, Integer stars) {
        roomService.changeRoomStars(IdRoom, stars);
    }

    public void changeRoomStatus(Integer idroom, RoomStatus roomStatus) { roomService.changeStatusRoom(idroom, roomStatus); }
    public void changeRoomCopacity(Integer idroom, Integer copacity) {  roomService.changeRoomCapacity(idroom, copacity);    }
    public void changeRoomPrice(Integer idroom, Integer price) {
        roomService.changeRoomPrice(idroom, price);
    }

    public List<Room> sortedByStars() {
        return roomService.sortedByStars();
    }

    public List<Room> sortedByCopacity() {
        return roomService.sortedByCapacity();
    }

    public List<Room> sortedByPrice() {
        return roomService.sortedByPrice();
    }

    public List<Room> allFreeRoom() {
        return roomService.allFreeRoom();
    }

}
