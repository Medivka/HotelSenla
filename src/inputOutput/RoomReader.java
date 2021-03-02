package inputOutput;

import api.enums.RoomStatus;
import dao.RoomDao;
import model.Room;
import service.RoomService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomReader {

    RoomService roomService = RoomService.getInstance();
    FileReader reader;
    String path = "rooms.txt";

    public void reader() {
        Integer capacity = 0;
        Integer stars = 0;
        Integer price = 0;
        try {
            reader = new FileReader("rooms.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String str = null;
        try {
            str = Files.lines(Path.of(path)).reduce("", String::concat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str1 = str.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        str1 = str1.replaceAll("\\s+", " ");
        String[] words = str1.split("\\s");

        for (int i = 0; i < words.length; i++) {

            if (words[i].equals("Room")) {
                RoomStatus roomStatus = RoomStatus.FREE;
                if (words[i + 3].equals("BUSY")) {
                    roomStatus = RoomStatus.BUSY;
                }
                if (words[i + 3].equals("FREE")) {
                    roomStatus = RoomStatus.FREE;
                }
                if (words[i + 3].equals("REPAIRS")) {
                    roomStatus = RoomStatus.REPAIRS;
                }
                if (words[i + 4].equals("capacity")) {
                    capacity = Integer.parseInt(words[i + 5]);
                }
                if (words[i + 6].equals("stars")) {
                    stars = Integer.parseInt(words[i + 7]);
                }
                if (words[i + 8].equals("price")) {
                    price = Integer.parseInt(words[i + 9]);
                }
                Room room = roomService.createRoom(roomStatus, capacity, price, stars);
            }
        }

    }
}