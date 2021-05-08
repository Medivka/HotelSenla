package com.api.fasad;

import com.model.Guest;
import com.model.Order;
import com.model.Room;

import java.util.List;

public interface IFasadHistory {

    void setHistoryList(List list);

    List<Order> getAllHistory();

    List<Guest> getLastThreeGuestInRoom(Integer IdRoom);

    List<Room> showAllRoomGuest(Integer IdGuest);
}
