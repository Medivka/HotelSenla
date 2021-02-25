package util;

public class IdGenerator {
    private static Integer guestID = 1;
    private static Integer roomID = 1;
    private static Integer serviceID = 1;
    private static Integer orderID = 1;
    private static Integer historyID = 1;



    public static Integer generateHistoryId() { return historyID++;}

    public static Integer generateGuestId() {
        return guestID++;
    }

    public static Integer generateOrderId() {
        return orderID++;
    }

    public static Integer generateRoomId() {
        return roomID++;
    }

    public static Integer generateServiceId() {
        return serviceID++;
    }
}
