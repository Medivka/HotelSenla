package controllers.mainMenuControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import interfaceController.IController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RoomMenuController implements IController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button createRoom;

    @FXML
    private Button findRoom;

    @FXML
    private Button showAllRoom;

    @FXML
    private Button changeRoom;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        createRoom.setOnAction(actionEvent -> {

            try {
                openNewScene(createRoomPath, createRoom);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        findRoom.setOnAction(actionEvent -> {

            try {
                openNewScene(findRoomPath, findRoom);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        showAllRoom.setOnAction(actionEvent -> {

            try {
                openNewScene(showAllRoomPath, showAllRoom);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        changeRoom.setOnAction(actionEvent -> {

            try {
                openNewScene(changeRoomPath, changeRoom);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }

    private String changeRoomPath = "/resources/room/changeRoom.fxml";
    private String backFieldPath = "/resources/Main.fxml";
    private String createRoomPath = "/resources/room/createNewRoom.fxml";
    private String findRoomPath = "/resources/room/findRoom.fxml";
    private String showAllRoomPath = "/resources/room/showAllRoom.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }


}
