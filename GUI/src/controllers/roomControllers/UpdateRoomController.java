package controllers.roomControllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import interfaceController.IController;
import com.api.enums.RoomStatus;
import com.fasad.FasadRoom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class UpdateRoomController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button updateRoom;

    @FXML
    private TextField newPriceField;

    @FXML
    private TextField newCapacityField;

    @FXML
    private RadioButton FREE;

    @FXML
    private ToggleGroup status;

    @FXML
    private RadioButton BUSY;

    @FXML
    private RadioButton REPAIRS;

    @FXML
    private ComboBox<Integer> newChooseStars;

    @FXML
    private TextField enterRoomNumber;

    @FXML
    private Button findRoom;

    @FXML
    private Label roomInfo;

    @FXML
    void initialize() {

        newChooseStars.getItems().addAll(1, 2, 3, 4, 5);
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        findRoom.setOnAction(actionEvent -> {
            Integer roomNumber = Integer.parseInt(enterRoomNumber.getText());
            if (roomNumber <= fasadRoom.showAllRoom().size() && roomNumber > 0) {
                roomInfo.setText(fasadRoom.findById(roomNumber).toString());
                newPriceField.setText(fasadRoom.findById(roomNumber).getPrice().toString());
                newCapacityField.setText(fasadRoom.findById(roomNumber).getCapacity().toString());
                newChooseStars.getSelectionModel().select(3);
                status.selectToggle(BUSY);

            } else roomInfo.setText("room not found");
        });
        updateRoom.setOnAction(actionEvent -> {
            Integer price = Integer.parseInt(newPriceField.getText());
            Integer capacity = Integer.parseInt(newCapacityField.getText());
            Integer stars = newChooseStars.getValue();
            RoomStatus roomStatus = null;
            if (FREE.isSelected()) {
                roomStatus = RoomStatus.FREE;
            }
            if (BUSY.isSelected()) {
                roomStatus = RoomStatus.BUSY;
            }
            if (REPAIRS.isSelected()) {
                roomStatus = RoomStatus.REPAIRS;
            }
            fasadRoom.findById(Integer.parseInt(enterRoomNumber.getText())).setPrice(price);
            fasadRoom.findById(Integer.parseInt(enterRoomNumber.getText())).setCopacity(capacity);
            fasadRoom.findById(Integer.parseInt(enterRoomNumber.getText())).setStars(stars);
            fasadRoom.findById(Integer.parseInt(enterRoomNumber.getText())).setRoomStatus(roomStatus);

            roomInfo.setText(fasadRoom.findById(Integer.parseInt(enterRoomNumber.getText())).toString());
            System.out.println(fasadRoom.findById(Integer.parseInt(enterRoomNumber.getText())));
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
