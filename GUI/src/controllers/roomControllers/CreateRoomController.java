package controllers.roomControllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import api.IController;
import api.enums.RoomStatus;
import fasad.FasadRoom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Room;

public class CreateRoomController implements IController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button createRoom;

    @FXML
    private TextField priceField;

    @FXML
    private TextField capacityField;

    @FXML
    private RadioButton FREE;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton BUSY;

    @FXML
    private RadioButton REPAIRS;

    @FXML
    private ComboBox<Integer> chooseStars;

    @FXML
    void initialize() {
        chooseStars.getItems().addAll(1, 2, 3, 4, 5);


        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        createRoom.setOnAction(actionEvent -> {

            Integer price = Integer.parseInt(priceField.getText());
            Integer capacity = Integer.parseInt(capacityField.getText());
            Integer stars = chooseStars.getValue();
            RoomStatus roomStatus = RoomStatus.FREE;
            if (FREE.isSelected()) {
                roomStatus = RoomStatus.FREE;
            }
            if (BUSY.isSelected()) {
                roomStatus = RoomStatus.BUSY;
            }
            if (REPAIRS.isSelected()) {
                roomStatus = RoomStatus.REPAIRS;
            }
            Room room = fasadRoom.createRoom(roomStatus, capacity, price, stars);
            System.out.println("create room: " + room);
            try {
                openNewScene(backFieldPath, createRoom);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }

    private String backFieldPath = "/resources/roomMenu.fxml";
    FasadRoom fasadRoom = FasadRoom.getInstance();

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }


}
