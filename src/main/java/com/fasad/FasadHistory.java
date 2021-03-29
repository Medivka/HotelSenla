package com.fasad;

import com.model.Guest;
import com.model.History;
import com.model.Order;
import com.model.Room;
import com.service.HistoryService;

import java.util.List;

public class FasadHistory {

    private static HistoryService historyService = HistoryService.getInstance();
    private static FasadHistory instance;

    public static FasadHistory getInstance() {
        if (instance == null) {
            instance = new FasadHistory();
        }
        return instance;
    }


    public void setHistoryList(List list){
        historyService.setHistoryList(list);
    }
    public List<Order> getAllHistory() {
        return historyService.getAllHistory();
    }

    public List<Guest> getLastThreeGuestInRoom(Integer IdRoom) {
        return historyService.getThreeLastGuests(IdRoom);
    }

    public List<Room> showAllRoomGuest(Integer IdGuest) {
        return historyService.showAllRoomGuest(IdGuest);
    }


}
