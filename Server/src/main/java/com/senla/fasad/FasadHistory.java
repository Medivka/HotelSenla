package com.senla.fasad;

import com.senla.api.fasad.IFasadHistory;
import com.senla.api.service.IHistoryService;
import com.senla.model.Guest;
import com.senla.model.Order;
import com.senla.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FasadHistory implements IFasadHistory {
    @Autowired
    IHistoryService historyService;


    @Override
    public void setHistoryList(List list) {

    }

    @Override
    public List<Order> getAllHistory() {
        return historyService.getAllHistory();
    }

    @Override
    public List<Guest> getLastThreeGuestInRoom(Integer IdRoom) {
        return historyService.getThreeLastGuests(IdRoom);
    }

    @Override
    public List<Room> showAllRoomGuest(Integer IdGuest) {
        return historyService.showAllRoomGuest(IdGuest);
    }


}
