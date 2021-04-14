package com.configsDB;

public class Constants {
    public static final String ORDER_TABLE = "orders";
    public static final String GUEST_TABLE = "senlahotel.guests";
    public static final String ROOM_TABLE = "rooms";
    public static final String SERVICE_TABLE = "senlahotel.services";
    public static final String HISTORY_TABLE = "history";
    public static final String ORDER_SERVICE_TABLE = "senlahotel.orders_services";


    public static final String GUEST_GUESTNUMBER = "guestNumber";
    public static final String GUEST_NAME = "NAME";
    public static final String GUEST_LASTNAME = "lastName";
    public static final String GUEST_AGE = "age";
    public static final String GUEST_PHONE = "phone";
    public static final String GUEST_GUESTGENDER = "guestGender";
    public static final String GUEST_EMAIL = "email";
    public static final String GUEST_ADDRESS = "address";

    public static final String SERVICE_ID = "id";
    public static final String SERVICE_NAME = "name";
    public static final String SERVICE_PRICE = "price";

    public static final String ROOM_NUMBER = "roomNumber";
    public static final String ROOM_STATUS = "roomStatus";
    public static final String ROOM_CAPACITY = "capacity";
    public static final String ROOM_STARS = "stars";
    public static final String ROOM_PRICE = "price";

    public static final String ORDER_ID = "id";
    public static final String ORDER_GUEST = "guests";
    public static final String ORDER_ROOM = "rooms";
    public static final String ORDER_SERVICES = "services";
    public static final String ORDER_LOCAL_DATE = "localDate";
    public static final String ORDER_DAYS_OF_STAY = "daysOfStay";
    public static final String ORDER_ALL_AMOUNT = "allAmount";

    public static final String ORDER_SERVICE_ID_ORDER = "id_order";
    public static final String ORDER_SERVICE_ID_SERVICE = "id_service";
}
