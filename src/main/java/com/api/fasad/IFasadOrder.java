package com.api.fasad;

import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;

import java.time.LocalDate;
import java.util.List;

public interface IFasadOrder {

    List showAllOrder();

    Order createNewOrder(Guest guest, Room room, Service service, LocalDate localDate, Integer daysOfStay);

    void addServiceInOrder(Order order, Service service);

    void addGuestInRoom(Integer orderNumber, Guest guest);

    void changeRoomInOrder(Integer orderNumber, Room room);

    void changeDaysOfStay(Integer orderNumber, Integer daysOfStay);

    Order findByID(Integer orderId);

    Integer getAllAmount(Integer orderNumber);

    abstract void setOrderList(List list);

    void deleteOrder(Order order);

    void updateOrder(Order order);
}
