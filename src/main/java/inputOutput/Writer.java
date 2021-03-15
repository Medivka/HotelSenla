package inputOutput;

import api.enums.RoomStatus;
import fasad.FasadRoom;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class Writer {
    public void writeInFile(String path, List list){
FasadRoom.getInstance().createRoom(RoomStatus.REPAIRS,3,45,45);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path)))
        {
            oos.writeObject(list);
            System.out.println("File has been written");
            oos.close();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }

    }

    public static void main(String[] args) {
        String a="src/main/java/hdd/room.dat";
        FasadRoom.getInstance().createRoom(RoomStatus.REPAIRS,3,45,46);
        Writer writer=new Writer();
        writer.writeInFile(a,FasadRoom.getInstance().showAllRoom());
    }
}
