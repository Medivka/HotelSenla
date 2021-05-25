package com.mappingDTO;

import com.dto.GuestDTO;
import com.dto.OrderDTO;
import com.dto.RoomDTO;
import com.dto.ServiceDTO;
import com.model.Guest;
import com.model.Order;
import com.model.Room;
import org.springframework.stereotype.Service;

@Service
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
        roomDTO.setStars(room.getPrice());

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

    public ServiceDTO mapServiceToServiceDTO(com.model.Service service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getId());
        serviceDTO.setName(service.getName());
        serviceDTO.setPrice(service.getPrice());
        return serviceDTO;
    }

    public com.model.Service mapServiceDtoToService(ServiceDTO serviceDTO) {
        com.model.Service service = new com.model.Service();
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
