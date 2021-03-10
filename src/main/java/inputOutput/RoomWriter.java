package inputOutput;

import dao.RoomDao;
import model.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RoomWriter {
    RoomDao roomDao=RoomDao.getInstance();
    ArrayList<Room> rooms= roomDao.getRoomList();
    FileWriter writer;
    public void writer() {
        {
            try {
                writer = new FileWriter("rooms.txt",true);
                writer.write(rooms.toString());
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

