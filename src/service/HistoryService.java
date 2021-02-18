package service;

import api.service.IHistoryService;
import dao.HistoryDao;
import model.Guest;
import model.Order;
import model.Room;

import java.util.ArrayList;

public class HistoryService implements IHistoryService {

    private final HistoryDao historyDao;

    public HistoryService(HistoryDao historyDao) {
        this.historyDao = historyDao;
    }


    @Override
    public void showAllHistory() {
        ArrayList<Order> history = historyDao.getHistoryList();
        for (Order story : history
        ) {
            System.out.println(story);

        }
    }

    @Override
    public void shawAllRoomGuest(Integer idGuest) {
        ArrayList<Order> historylist = new ArrayList<>(historyDao.getHistoryList());
        for (int i = 0; i < historylist.size(); i++) {
            Order order = historylist.get(i);
            ArrayList<Guest> guests = (ArrayList<Guest>) order.getGuests();
            for (int k = 0; k < guests.size(); k++) {
                Guest guest = guests.get(k);
                if (guest.getGuestNumber().equals(idGuest)) {
                    System.out.println(order.getRooms());
                    System.out.println("Settling: " + order.getLocalDate());
                    System.out.println("Departure: " + order.getLocalDate().plusDays(order.getDaysOfStay()) + "\n");

                }
            }
        }

    }

}

