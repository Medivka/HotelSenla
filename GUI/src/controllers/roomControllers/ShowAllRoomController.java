package controllers.roomControllers;

import api.IController;
import api.enums.RoomStatus;
import fasad.FasadRoom;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Room;

public class ShowAllRoomController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TableView<Room> tableRoom;

    @FXML
    private TableColumn<Room, Integer> id;

    @FXML
    private TableColumn<Room, RoomStatus> roomStatus;

    @FXML
    private TableColumn<Room, Integer> price;

    @FXML
    private TableColumn<Room, Integer> capacity;

    @FXML
    private TableColumn<Room, Integer> stars;

    @FXML
    void initialize() {

        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        id.setCellValueFactory(new PropertyValueFactory<Room, Integer>("roomNumber"));
        roomStatus.setCellValueFactory(new PropertyValueFactory<Room, RoomStatus>("roomStatus"));
        price.setCellValueFactory(new PropertyValueFactory<Room, Integer>("price"));
        capacity.setCellValueFactory(new PropertyValueFactory<Room, Integer>("capacity"));
        stars.setCellValueFactory(new PropertyValueFactory<Room, Integer>("stars"));

        ObservableList<Room> rooms = FXCollections.observableArrayList(fasadRoom.showAllRoom());
        tableRoom.setItems(rooms);

    }

    String backFieldPath = "/resources/roomMenu.fxml";
    FasadRoom fasadRoom = FasadRoom.getInstance();

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }

}
