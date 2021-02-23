package api.service;

import model.Guest;
import model.History;

import java.util.List;

public interface IHistoryService {
   List getAllHistory();

    List<Guest> getThreeLastGuests(Integer roomID);

   List shawAllRoomGuest(Integer idGuest);
}
