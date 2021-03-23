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

public class UpdateServiceController implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;
    @FXML
    private TextField idServiceField;

    @FXML
    private TextField newNameField;

    @FXML
    private TextField newPriceField;

    @FXML
    private Button findService;

    @FXML
    private Label findServiceLabel;

    @FXML
    private Button updateButton;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        findService.setOnAction(actionEvent -> {
            Integer serviceId = Integer.parseInt(idServiceField.getText());
            if(serviceId<=fasadService.showAllService().size()&&serviceId>0){
                findServiceLabel.setText(fasadService.findByID(serviceId).toString());
            newNameField.setText(fasadService.findByID(serviceId).getName());
            newPriceField.setText(fasadService.findByID(serviceId).getPrice().toString());}
            else findServiceLabel.setText("Service not found");
        });
        updateButton.setOnAction(actionEvent -> {
            Integer id=Integer.parseInt(idServiceField.getText());
                    String name = newNameField.getText();
                    Integer price = Integer.parseInt(newPriceField.getText());
                    fasadService.changeServiceName(id,name);
                    fasadService.changeServicePrice(id,price);
            System.out.println(fasadService.findByID(id));
        });


    }

    String backFieldPath = "/resources/serviceMenu.fxml";
    FasadService fasadService=FasadService.getInstance();

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}

