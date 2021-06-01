package com.senla.dto.mappingDTO;

import com.senla.dto.modelDTO.GuestDTO;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.dto.modelDTO.ServiceDTO;
import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.model.Service;


@org.springframework.stereotype.Service
public class MappingDTO {


    public GuestDTO mapGuestToGuestDTO(Guest guest) {
        GuestDTO guestDTO = new GuestDTO();
        guestDTO.setGuestNumber(guest.getGuestNumber());
        guestDTO.setName(guest.getName());
        guestDTO.setLastName(guest.getLastName());
        guestDTO.setAge(guest.getAge());
        guestDTO.setPhone(guest.getPhone());
        guestDTO.setGuestGender(guest.getGuestGender());
        guestDTO.setEmail(guest.getEmail());
        guestDTO.setAddress(guest.getAddress());
        return guestDTO;
    }

    public Guest mapGuestDtoTOGuest(GuestDTO guestDTO) {
        Guest guest = new Guest();
        guest.setGuestNumber(guestDTO.getGuestNumber());
        guest.setName(guestDTO.getName());
        guest.setLastName(guestDTO.getLastName());
        guest.setAge(guestDTO.getAge());
        guest.setPhone(guestDTO.getPhone());
        guest.setGuestGender(guestDTO.getGuestGender());
        guest.setEmail(guestDTO.getEmail());
        guest.setAddress(guestDTO.getAddress());
        return guest;
    }

    public RoomDTO mapRoomToRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setRoomStatus(room.getRoomStatus());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setStars(room.getStars());

        return roomDTO;
    }

    public Room mapRoomDtoToRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setStars(roomDTO.getStars());
        room.setRoomStatus(roomDTO.getRoomStatus());
        room.setCopacity(roomDTO.getCapacity());
        return room;
    }

    public ServiceDTO mapServiceToServiceDTO(Service service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getId());
        serviceDTO.setName(service.getName());
        serviceDTO.setPrice(service.getPrice());
        return serviceDTO;
    }

    public Service mapServiceDtoToService(ServiceDTO serviceDTO) {
       Service service = new Service();
        service.setId(serviceDTO.getId());
        service.setPrice(serviceDTO.getPrice());
        service.setName(serviceDTO.getName());

        return service;
    }

    public OrderDTO mapOrderToOrderDTO(Order order){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setGuest(order.getGuest());
        orderDTO.setId(order.getId());
        orderDTO.setRoom(order.getRoom());
        orderDTO.setAllAmount(order.getAllAmount());
        orderDTO.setServices(order.getServices());
        orderDTO.setLocalDate(order.getLocalDate());
        orderDTO.setDaysOfStay(order.getDaysOfStay());
        return orderDTO;
    }
    public Order mapOrderDtoToOrder(OrderDTO orderDTO){
        Order order= new Order();
        order.setGuest(orderDTO.getGuest());
        order.setId(orderDTO.getId());
        order.setRoom(orderDTO.getRoom());
        order.setAllAmount(orderDTO.getAllAmount());
        order.setServices(orderDTO.getServices());
        order.setLocalDate(orderDTO.getLocalDate());
        order.setDaysOfStay(orderDTO.getDaysOfStay());
        return order;
    }

}
