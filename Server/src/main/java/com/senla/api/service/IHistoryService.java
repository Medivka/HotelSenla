package com.senla.api.service;



import com.senla.model.Guest;

import java.util.List;

public interface IHistoryService {
   List getAllHistory();

   List<Guest> getThreeLastGuests(Integer roomID);

   List showAllRoomGuest(Integer idGuest);


}
