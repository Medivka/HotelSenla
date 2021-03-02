package service;

import api.service.IHistoryService;
import dao.GuestDao;
import dao.HistoryDao;
import exceptions.DaoException;
import exceptions.ServiceExeption;
import model.Guest;
import model.History;
import model.Room;

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


    @Override
    public List<History> getAllHistory() {

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
            List<History> historyList = new ArrayList<>(historyDao.getHistoryList());
            for (int i = 0; i < historyList.size(); i++) {
                History history = historyList.get(i);
                List<Guest> guestList = history.getGuests();
                List<Room> roomList = history.getRooms();

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
            List<History> historyList = new ArrayList<>(historyDao.getHistoryList());
            for (int i = 0; i < historyList.size(); i++) {
                History history = historyList.get(i);
                List<Guest> guest = history.getGuests();
                List<Room> room = history.getRooms();
                for (int k = 0; k < guest.size(); k++) {
                    Guest guest1 = guest.get(k);
                    if (guest1.getGuestNumber().equals(idGuest)) {
                        for (int j = 0; j < room.size(); j++) {
                            rooms.add(room.get(j));
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
