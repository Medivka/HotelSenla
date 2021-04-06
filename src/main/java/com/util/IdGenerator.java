package com.util;

public class IdGenerator {
    public static void setGuestID(Integer guestID) {
        IdGenerator.guestID = guestID;
    }

    public static void setRoomID(Integer roomID) {
        IdGenerator.roomID = roomID;
    }

    public static void setServiceID(Integer serviceID) {
        IdGenerator.serviceID = serviceID;
    }

    public static void setOrderID(Integer orderID) {
        IdGenerator.orderID = orderID;
    }

    public static void setHistoryID(Integer historyID) {
        IdGenerator.historyID = historyID;
    }

    private static Integer guestID = 1;
    private static Integer roomID = 1;
    private static Integer serviceID = 1;
    private static Integer orderID = 1;
    private static Integer historyID = 1;


    public static Integer generateHistoryId() {
        return historyID++;
    }

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
