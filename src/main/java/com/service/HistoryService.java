package com.service;

import com.api.dao.IHistoryDao;
import com.api.service.IHistoryService;
import com.dao.HistoryDao;
import com.exceptions.DaoException;
import com.exceptions.ServiceExeption;
import com.model.Guest;

import com.model.Order;
import com.model.Room;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

@Component
public class HistoryService implements IHistoryService {

    private static final Logger LOGGER = Logger.getLogger(HistoryService.class.getName());

    IHistoryDao historyDao;

    @Autowired
    public HistoryService(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }
    public void setHistoryList(List list) {
        historyDao.setHistoryList((ArrayList<Order>) list);
    }

    @Override
    public List<Order> getAllHistory() {

        try {
            return new ArrayList<>(historyDao.getHistoryList());
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "getThreeLastGuest failed", e);
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
                Room room = order.getRoom();
                if (roomID.equals(room.getId())) {
                    threeLastGuest.add(order.getGuest());
                }
            }
            return threeLastGuest.stream().limit(3).collect(Collectors.toList());
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "getThreeLastGuest failed", e);
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
                if (order.getGuest().getGuestNumber().equals(idGuest)) {
                    rooms.add(order.getRoom());
                }
            }
            return rooms;
        } catch (DaoException e) {
            LOGGER.log(Level.WARN, "showAllRoomGuest failed", e);
            throw new ServiceExeption("showAllRoomGuest failed", e);
        }
    }
}
