package com.fasad;



import com.api.enums.GuestGender;
import com.api.fasad.IFasadGuest;
import com.api.service.IGuestService;
import com.model.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class FasadGuest implements IFasadGuest {

    @Autowired
    IGuestService guestService;

    @Override
    public Guest findById(Integer guestNumber) {
        Guest guest = guestService.findById(guestNumber);
        return guest;
    }

    @Override
    public void changeName(Integer idGuest, String Name) {
        guestService.changeGuestName(idGuest, Name);
    }

    @Override
    public List<Guest> showAllGuests() {
        return guestService.showAllGuests();
    }

    @Override
    public Guest createNewGuest(String name, String lastName, Integer age, String phone, GuestGender guestGender, String email, String address) {
        return guestService.createGuest(name, lastName, age, phone, guestGender, email, address);
    }

    @Override
    public void changeGuestAge(Integer idGuest, Integer Age) {
        guestService.changeGuestAge(idGuest, Age);
    }

    @Override
    public List<Guest> sortedByAge() {
        return guestService.sortedByAge();
    }

    @Override
    public List<Guest> sortedById() {
        return guestService.sortedById();
    }

    @Override
    public List<Guest> sortedByName() {
        return guestService.sortedByName();
    }

    @Override
    public void deleteGuest(Guest guest) {
        guestService.deleteGuest(guest);
    }

    @Override
    public void setGuestList(List list) {
        guestService.setGuestLIst(list);
    }

    @Override
    public void updateGuest(Guest guest) {
        guestService.updateGuest(guest);
    }


}
