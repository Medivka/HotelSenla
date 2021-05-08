package com.fasad;

import com.api.fasad.IFasadHistory;
import com.model.Guest;
import com.model.History;
import com.model.Order;
import com.model.Room;
import com.service.HistoryService;

import java.util.List;

public class FasadHistory implements IFasadHistory {

    private static HistoryService historyService = HistoryService.getInstance();
    private static FasadHistory instance;

    public static FasadHistory getInstance() {
        if (instance == null) {
            instance = new FasadHistory();
        }
        return instance;
    }

    @Override
    public void setHistoryList(List list) {
        historyService.setHistoryList(list);
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
