package inputOutput;

import fasad.FasadRoom;
import model.Room;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static void main(String[] args) {
        String a="src/main/java/hdd/room.dat";
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(a)))
        {

          FasadRoom.getInstance().setRoomList( (ArrayList<Room>) ois.readObject());
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
        System.out.println(FasadRoom.getInstance().showAllRoom());
    }
}
