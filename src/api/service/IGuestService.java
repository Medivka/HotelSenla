package api.service;

import model.Guest;

import java.util.List;

public interface IGuestService {
    Guest findById(Integer id);

    void showAllGuests();

    Guest createGuest(String name, Integer age);

    void changeGuestName(Integer idGuest, String name);

    void changeGuestAge(Integer idGuest, Integer age);

    List sortedByAge();
}
