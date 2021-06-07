package com.senla.api.service;



import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.model.Service;

import java.time.LocalDate;
import java.util.List;

public interface IOrderService {


    List<Order> showAllOrder();

    Order createNewOrder(Guest guest, Room room, Service service, LocalDate localDate, Integer daysOfStay);

    void addGuestInRoom(Integer orderNumber, Guest guest);

    void addServiceInOrder(Order order, Service service);



    void changeRoomInOrder(Integer orderNumber, Room room);

    void changeDaysOfStay(Integer orderNumber, Integer daysOfStay);

    Order findById(Integer orderId);

    Integer getAllAmount(Integer orderNumber);

    void deleteOrder(Integer id);

    void setOrderList(List list);

    void updateOrder(Order order);

    void save(Order order);
}
