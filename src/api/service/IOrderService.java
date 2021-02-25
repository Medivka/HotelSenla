package api.service;

import model.Guest;
import model.Order;
import model.Room;
import model.Service;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {


    Order createNewOrder(Guest guest, Room room, Service service, LocalDate localDate, Integer daysOfStay);

    Order showOrder(Integer orderNumber);

    void addGuestInRoom(Integer orderNumber, Guest guest);

    void addInRoomService(Integer orderNumber, Service service);

    void changeRoomInOrder(Integer orderNumber, Room room);

    void changeDaysOfStay(Integer orderNumber, Integer daysOfStay);

    long getAllAmount(Integer orderNumber);
}
