package fasad;

import model.Guest;
import model.History;
import model.Room;
import service.HistoryService;

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


    public List<History> getAllHistory() {
        return historyService.getAllHistory();
    }

    public List<Guest> getLastThreeGuestInRoom(Integer IdRoom) {
        return historyService.getThreeLastGuests(IdRoom);
    }

    public List<Room> showAllRoomGuest(Integer IdGuest) {
        return historyService.shawAllRoomGuest(IdGuest);
    }


}
