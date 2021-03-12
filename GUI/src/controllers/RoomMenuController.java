package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RoomMenuController {


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
                openNewScene(backFieldPath,backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        createRoom.setOnAction(actionEvent -> {
            System.out.println("hello");

        });




    }
    private String backFieldPath="/resourses/Main.fxml";
    private String createRoomPath= "resourses/room/createNewRoom.fxml";
    private String findRoomPath="resourses/room/findRoom.fxml";
    private String showAllRoomPath= "resourses/room/showAllRoom.fxml";
    public void openNewScene(String path,Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window= (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root,445,590));
    }
}
