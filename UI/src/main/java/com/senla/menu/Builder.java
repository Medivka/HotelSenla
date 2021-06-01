package com.senla.menu;

import  com.senla.actions.guest.*;
import com.senla.actions.history.GetAllHistory;
import com.senla.actions.history.GetThreeLastGuestInRoom;
import com.senla.actions.history.ShowAllRoomGuest;
import com.senla.actions.order.*;
import com.senla.actions.room.*;
import com.senla.actions.room.FindById;
import com.senla.actions.service.ChangeServiceName;
import com.senla.actions.service.ChangeServicePrice;
import com.senla.actions.service.CreateNewService;
import com.senla.actions.service.ShowAllService;
import org.springframework.stereotype.Component;

@Component
public class Builder {

    private static Builder builder;
    private Menu rootMenu = new Menu();

    private Builder() {
    }

    public Menu getRootMenu() {

        return rootMenu;
    }



    public void buildMenu() {
        rootMenu.addMenuItem(new MenuItem("Order ", () -> {
        }, createOrderMenu()));
        rootMenu.addMenuItem(new MenuItem("Guest ", () -> {
        }, createGuestMenu()));
        rootMenu.addMenuItem(new MenuItem("Room ", () -> {
        }, createRoomMenu()));
        rootMenu.addMenuItem(new MenuItem("Service ", () -> {
        }, createServiceMenu()));
        rootMenu.addMenuItem(new MenuItem("History ", () -> {
        }, historyMenu()));

    }


    private Menu createServiceMenu() {
        Menu serviceMenu = new Menu();

        serviceMenu.addMenuItem(new MenuItem("Create new com.service", new CreateNewService(), rootMenu));
        serviceMenu.addMenuItem(new MenuItem("Find by id", new FindById(), rootMenu));
        serviceMenu.addMenuItem(new MenuItem("Show all com.service", new ShowAllService(), rootMenu));
        serviceMenu.addMenuItem(new MenuItem("Sorted by price", new SortedByPrice(), rootMenu));
        serviceMenu.addMenuItem(new MenuItem("Change com.service name", new ChangeServiceName(), rootMenu));
        serviceMenu.addMenuItem(new MenuItem("Change com.service price", new ChangeServicePrice(), rootMenu));
        return serviceMenu;
    }

    private Menu historyMenu() {
        Menu historyMenu = new Menu();
        historyMenu.addMenuItem(new MenuItem("Get all History", new GetAllHistory(), rootMenu));
        historyMenu.addMenuItem(new MenuItem("Get three last guest in room", new GetThreeLastGuestInRoom(), rootMenu));
        historyMenu.addMenuItem(new MenuItem("Show All room guest", new ShowAllRoomGuest(), rootMenu));
        return historyMenu;
    }

    private Menu createGuestMenu() {
        Menu guestMenu = new Menu();
        guestMenu.addMenuItem(new MenuItem("Create new guest", new CreateNewGuest(), rootMenu));
        guestMenu.addMenuItem(new MenuItem("Change guest name", new ChangeGuestName(), rootMenu));
        guestMenu.addMenuItem(new MenuItem("Change guest age", new ChangeGuestAge(), rootMenu));
        guestMenu.addMenuItem(new MenuItem("Find by id", new FindById(), rootMenu));
        guestMenu.addMenuItem(new MenuItem("Show all guests", new ShowAllGuest(), rootMenu));
        guestMenu.addMenuItem(new MenuItem("Sorted by age", new SortedByAge(), rootMenu));
        guestMenu.addMenuItem(new MenuItem("Sorted by id", new SortedById(), rootMenu));
        guestMenu.addMenuItem(new MenuItem("Sorted by name", new SortedByName(), rootMenu));
        return guestMenu;
    }

    private Menu createOrderMenu() {
        Menu orderMenu = new Menu();
        orderMenu.addMenuItem(new MenuItem("Get all Amount", new GetAllAmount(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Create new Order", new CreateNewOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Change Room in Order", new ChangeRoomInOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Show Order ", new ShowOrder(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Change days of stay in Order", new ChangeDaysOfStay(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Add Service in room ", new AddInRoomService(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Add guest in room", new AddGuestInRoom(), rootMenu));
        orderMenu.addMenuItem(new MenuItem("Find by ID", new FindById(), rootMenu));
        return orderMenu;
    }


    private Menu createRoomMenu() {
        Menu roomMenu = new Menu();
        roomMenu.addMenuItem(new MenuItem("Create Room", new CreateRoom(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Change Room Capacity", new ChangeRoomCapacity(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Change Room Price", new ChangeRoomPrice(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Change Room Stars", new ChangeRoomStars(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Change Room Status", new ChangeRoomStatus(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Find by ID Room", new FindById(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Show All Free Rooms", new ShowAllFreeRoom(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Show All Room", new ShowAllRoom(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Sorted by Capacity", new SortedByCapacity(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Sorted by Price", new SortedByPrice(), rootMenu));
        roomMenu.addMenuItem(new MenuItem("Sorted by Stars", new SortedByStars(), rootMenu));
        return roomMenu;
    }


}
