package com.service;

import com.api.service.IHistoryService;
import com.dao.HistoryDao;
import com.exceptions.DaoException;
import com.exceptions.ServiceExeption;
import com.model.Guest;
import com.model.History;
import com.model.Order;
import com.model.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HistoryService implements IHistoryService {
    private static final Logger LOGGER = Logger.getLogger(HistoryService.class.getName());
    private final HistoryDao historyDao;
    private static HistoryService instance;

    public static HistoryService getInstance() {
        if (instance == null) {
            instance = new HistoryService(HistoryDao.getInstance());
        }
        return instance;
    }


    public HistoryService(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }


    public void setHistoryList(List list){
        historyDao.setHistoryList((ArrayList<Order>) list);
    }

    @Override
    public List<Order> getAllHistory() {

        try {
            return new ArrayList<>(historyDao.getHistoryList());
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "getThreeLastGuest failed", e);
            throw new ServiceExeption("getAllHistory failed", e);
        }
    }

    @Override
    public List<Guest> getThreeLastGuests(Integer roomID) {
        try {
            LOGGER.log(Level.INFO, String.format("getThreeLastGuest  room: %s", roomID));
            List<Guest> threeLastGuest = new ArrayList<>();
            List<Order> historyList = new ArrayList<>(historyDao.getHistoryList());
            for (int i = 0; i < historyList.size(); i++) {
                Order order = historyList.get(i);
                List<Guest> guestList = order.getGuests();
                List<Room> roomList = order.getRooms();
                for (int k = 0; k < roomList.size(); k++) {
                    Room room = roomList.get(k);
                    if (room.getRoomNumber().equals(roomID)) {
                        for (int j = 0; j < guestList.size(); j++) {
                            threeLastGuest.add(guestList.get(j));
                        }
                    }
                }
            }
            return threeLastGuest.stream().limit(3).collect(Collectors.toList());
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "getThreeLastGuest failed", e);
            throw new ServiceExeption("getThreeLastGuest failed", e);
        }
    }


    @Override
    public List<Room> showAllRoomGuest(Integer idGuest) {
        try {
            LOGGER.log(Level.INFO, String.format("showAllRoomGuest: %s", idGuest));
            List<Room> rooms = new ArrayList<>();
            List<Order> historyList = new ArrayList<>(historyDao.getHistoryList());
            for (int i = 0; i < historyList.size(); i++) {
                Order order = historyList.get(i);
                List<Guest> guest = order.getGuests();
                List<Room> room = order.getRooms();
                for (int k = 0; k < guest.size(); k++) {
                    Guest guest1 = guest.get(k);
                    if (guest1 == null) {
                        System.out.println("guest not found");
                    } else {
                        if (guest1.getGuestNumber().equals(idGuest)) {
                            for (int j = 0; j < room.size(); j++) {
                                rooms.add(room.get(j));
                            }
                        }
                    }
                }
            }
            return rooms;
        } catch (DaoException e) {
            LOGGER.log(Level.WARNING, "showAllRoomGuest failed", e);
            throw new ServiceExeption("showAllRoomGuest failed", e);

        }
    }


}
