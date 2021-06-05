package com.senla.dto.apiDTO;

import com.senla.dto.modelDTO.GuestDTO;
import com.senla.dto.modelDTO.OrderDTO;
import com.senla.dto.modelDTO.RoomDTO;
import com.senla.dto.modelDTO.ServiceDTO;
import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import com.senla.model.Service;

public interface MappingDTO {
    GuestDTO mapGuestToGuestDTO(Guest guest);

    Guest mapGuestDtoTOGuest(GuestDTO guestDTO);

    RoomDTO mapRoomToRoomDTO(Room room);

    Room mapRoomDtoToRoom(RoomDTO roomDTO);

    ServiceDTO mapServiceToServiceDTO(Service service);

    Service mapServiceDtoToService(ServiceDTO serviceDTO);

    OrderDTO mapOrderToOrderDTO(Order order);

    Order mapOrderDtoToOrder(OrderDTO orderDTO);
}
