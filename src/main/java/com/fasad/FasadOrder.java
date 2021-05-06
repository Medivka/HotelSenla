package com.fasad;

import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;
import com.service.OrderService;

import java.time.LocalDate;
import java.util.List;

public class FasadOrder {
    private static OrderService orderService = OrderService.getInstance();
    private static FasadOrder instance;

    public static FasadOrder getInstance() {
        if (instance == null) {
            instance = new FasadOrder();
        }
        return instance;
    }

    public List showAllOrder() {
        return orderService.showAllOrder();
    }

    public Order createNewOrder(Guest guest, Room room, Service service, LocalDate localDate, Integer daysOfStay) {
        return orderService.createNewOrder(guest, room, service, localDate, daysOfStay);
    }

    public void addServiceInOrder(Order order, Service service) {
        orderService.addServiceInOrder(order, service);
    }



    public void addGuestInRoom(Integer orderNumber, Guest guest) {
        orderService.addGuestInRoom(orderNumber, guest);
    }

    public void changeRoomInOrder(Integer orderNumber, Room room) {
        orderService.changeRoomInOrder(orderNumber, room);
    }

    public void changeDaysOfStay(Integer orderNumber, Integer daysOfStay) {
        orderService.changeDaysOfStay(orderNumber, daysOfStay);
    }

    public Order findByID(Integer orderId) {
        return orderService.findById(orderId);
    }

    public Integer getAllAmount(Integer orderNumber) {
        return orderService.getAllAmount(orderNumber);
    }

    public void setOrderList(List list) {
        orderService.setOrderList(list);
    }
    public void deleteOrder(Order order){
        orderService.deleteOrder(order);
    }

 public void updateOrder(Order order){
        orderService.updateOrder(order);
 }
}
