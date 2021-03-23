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

public class ServiceMenuController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private Button createService;

    @FXML
    private Button findServiceById;

    @FXML
    private Button showAllService;

    @FXML
    private Button updateService;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        findServiceById.setOnAction(actionEvent -> {
            try {
                openNewScene(findByIdServicePath, findServiceById);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }); createService.setOnAction(actionEvent -> {
            try {
                openNewScene(createNewServicePath, createService);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }); showAllService.setOnAction(actionEvent -> {
            try {
                openNewScene(showAllServicePath, showAllService);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }); updateService.setOnAction(actionEvent -> {
            try {
                openNewScene(updateServicePath, updateService);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    }
    private String backFieldPath = "/resources/Main.fxml";
    private String findByIdServicePath = "/resources/service/findService.fxml";
    private String showAllServicePath = "/resources/service/showAllService.fxml";
    private String updateServicePath = "/resources/service/updateService.fxml";
    private String createNewServicePath = "/resources/service/createService.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}
