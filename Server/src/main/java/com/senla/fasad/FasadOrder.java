package com.senla.fasad;

import com.senla.api.fasad.IFasadOrder;
import com.senla.api.service.IOrderService;
import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class FasadOrder implements IFasadOrder {

    @Autowired
    IOrderService orderService;


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
