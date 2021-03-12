package controllers.roomControllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import api.IController;
import fasad.FasadRoom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    private TextField copacityField;

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
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        chooseStars.getItems().addAll(1, 2, 3, 4, 5);
        createRoom.setOnAction(actionEvent -> {

        });

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
