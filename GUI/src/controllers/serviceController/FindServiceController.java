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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FindServiceController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TextField id;

    @FXML
    private Button findButton;

    @FXML
    private Label labelServiceFind;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
        try {
            openNewScene(backFieldPath, backField);
        } catch (IOException e) {
            e.printStackTrace();
        }
    });
        findButton.setOnAction(actionEvent -> {
            Integer serviceId = Integer.parseInt(id.getText());
            if(serviceId<=fasadService.showAllService().size()&&serviceId>0){
                labelServiceFind.setText(fasadService.findByID(serviceId).toString());}else labelServiceFind.setText("Service not found");
        });


    }
    FasadService fasadService=FasadService.getInstance();
    String backFieldPath = "/resources/serviceMenu.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}

