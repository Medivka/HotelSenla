package com.senla.api.fasad;


import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;

import java.util.List;

public interface IFasadHistory {

    void setHistoryList(List list);

    List<Order> getAllHistory();

    List<Guest> getLastThreeGuestInRoom(Integer IdRoom);

    List<Room> showAllRoomGuest(Integer IdGuest);
}
