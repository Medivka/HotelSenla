package com.senla.dto.mappingDTO;


import com.senla.dto.apiDTO.MappingDTO;
import com.senla.dto.modelDTO.GuestDTO;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.dto.modelDTO.ServiceDTO;
import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.model.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@org.springframework.stereotype.Service
public class MappingDTOImpl implements MappingDTO {

    @Override
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

    @Override
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

    @Override
    public RoomDTO mapRoomToRoomDTO(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setId(room.getId());
        roomDTO.setRoomStatus(room.getRoomStatus());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setPrice(room.getPrice());
        roomDTO.setStars(room.getStars());

        return roomDTO;
    }

    @Override
    public Room mapRoomDtoToRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setId(roomDTO.getId());
        room.setStars(roomDTO.getStars());
        room.setRoomStatus(roomDTO.getRoomStatus());
        room.setCopacity(roomDTO.getCapacity());
        return room;
    }

    @Override
    public ServiceDTO mapServiceToServiceDTO(Service service) {
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getId());
        serviceDTO.setName(service.getName());
        serviceDTO.setPrice(service.getPrice());
        return serviceDTO;
    }

    @Override
    public Service mapServiceDtoToService(ServiceDTO serviceDTO) {
        Service service = new Service();
        service.setId(serviceDTO.getId());
        service.setPrice(serviceDTO.getPrice());
        service.setName(serviceDTO.getName());

        return service;
    }

    @Override
    public OrderDTO mapOrderToOrderDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setGuestDTO(mapGuestToGuestDTO(order.getGuest()));
        orderDTO.setId(order.getId());
        orderDTO.setRoomDTO(mapRoomToRoomDTO(order.getRoom()));
        orderDTO.setAllAmount(order.getAllAmount());
        List<Service> services = order.getServices();
        List<ServiceDTO> serviceDTOList = new LinkedList<>();
        for (Service se : services) {
            ServiceDTO serviceDTO = mapServiceToServiceDTO(se);
            serviceDTOList.add(serviceDTO);
        }
        orderDTO.setServicesDTO(serviceDTOList);
        orderDTO.setLocalDate(order.getLocalDate());
        orderDTO.setDaysOfStay(order.getDaysOfStay());
        return orderDTO;
    }

    @Override
    public Order mapOrderDtoToOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setGuest(mapGuestDtoTOGuest(orderDTO.getGuestDTO()));
        order.setId(orderDTO.getId());
        order.setRoom(mapRoomDtoToRoom(orderDTO.getRoomDTO()));
        order.setAllAmount(orderDTO.getAllAmount());
        List<ServiceDTO> serviceDTOList = orderDTO.getServicesDTO();
        List<Service> services = new LinkedList<>();
        for (ServiceDTO se : serviceDTOList) {
            Service service = mapServiceDtoToService(se);
            services.add(service);
        }
        order.setServices(services);
        order.setLocalDate(orderDTO.getLocalDate());
        order.setDaysOfStay(orderDTO.getDaysOfStay());
        return order;
    }

}



