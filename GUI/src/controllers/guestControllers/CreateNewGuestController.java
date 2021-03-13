package controllers.guestControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import api.IController;
import fasad.FasadGuest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateNewGuestController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField ageField;

    @FXML
    private Button createNewGuest;

    @FXML
    void initialize() {

        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        createNewGuest.setOnAction(actionEvent -> {
            String name=nameField.getText();
            Integer age= Integer.parseInt(ageField.getText());
            System.out.println("create Guest: "+ fasadGuest.createNewGuest(name,age));
            try {
                openNewScene(backFieldPath,createNewGuest);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
    FasadGuest fasadGuest= FasadGuest.getInstance();
    String backFieldPath = "/resources/guestMenu.fxml";
    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}
