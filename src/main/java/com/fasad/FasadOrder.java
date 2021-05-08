package com.fasad;

import com.api.fasad.IFasadOrder;
import com.model.Guest;
import com.model.Order;
import com.model.Room;
import com.model.Service;
import com.service.OrderService;

import java.time.LocalDate;
import java.util.List;

public class FasadOrder implements IFasadOrder {
    private static OrderService orderService = OrderService.getInstance();
    private static FasadOrder instance;

    public static FasadOrder getInstance() {
        if (instance == null) {
            instance = new FasadOrder();
        }
        return instance;
    }

    @Override
    public List showAllOrder() {
        return orderService.showAllOrder();
    }

    @Override
    public Order createNewOrder(Guest guest, Room room, Service service, LocalDate localDate, Integer daysOfStay) {
        return orderService.createNewOrder(guest, room, service, localDate, daysOfStay);
    }

    @Override
    public void addServiceInOrder(Order order, Service service) {
        orderService.addServiceInOrder(order, service);
    }


    @Override
    public void addGuestInRoom(Integer orderNumber, Guest guest) {
        orderService.addGuestInRoom(orderNumber, guest);
    }

    @Override
    public void changeRoomInOrder(Integer orderNumber, Room room) {
        orderService.changeRoomInOrder(orderNumber, room);
    }

    @Override
    public void changeDaysOfStay(Integer orderNumber, Integer daysOfStay) {
        orderService.changeDaysOfStay(orderNumber, daysOfStay);
    }

    @Override
    public Order findByID(Integer orderId) {
        return orderService.findById(orderId);
    }

    @Override
    public Integer getAllAmount(Integer orderNumber) {
        return orderService.getAllAmount(orderNumber);
    }

    @Override
    public void setOrderList(List list) {
        orderService.setOrderList(list);
    }

    @Override
    public void deleteOrder(Order order) {
        orderService.deleteOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderService.updateOrder(order);
    }
}
