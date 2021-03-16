package api.service;

import model.Guest;

import java.util.List;

public interface IGuestService {
    Guest findById(Integer id);

    List showAllGuests();

    Guest createGuest(String name, Integer age);

    void changeGuestName(Integer idGuest, String name);

    void changeGuestAge(Integer idGuest, Integer age);

    List sortedByAge();

    List sortedById();

    List sortedByName();

    void setGuestLIst(List list);

    void writeInFile();

    void readFromFile();
}
