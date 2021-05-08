package com.fasad;

import com.api.fasad.IFasadHistory;
import com.api.service.IHistoryService;
import com.model.Guest;
import com.model.History;
import com.model.Order;
import com.model.Room;
import com.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FasadHistory implements IFasadHistory {
    @Autowired
    IHistoryService historyService ;


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
