package controllers.serviceController;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import interfaceController.IController;
import com.fasad.FasadService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateNewServiceController implements IController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private Button createNewService;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        createNewService.setOnAction(actionEvent -> {
            String name = nameField.getText();
            Integer price = Integer.parseInt(priceField.getText());
            System.out.println(fasadService.createNewService(name, price));
            try {
                openNewScene(backFieldPath, createNewService);
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

    @Override
    public void openNewScene(String path, Button button) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }

    FasadService fasadService = FasadService.getInstance();
    private String backFieldPath = "/resources/serviceMenu.fxml";
}

