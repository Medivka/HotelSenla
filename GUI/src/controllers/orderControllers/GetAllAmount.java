package controllers.orderControllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import api.IController;
import fasad.FasadOrder;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GetAllAmount implements IController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backFiled;

    @FXML
    private Button orderFind;

    @FXML
    private TextField orderFindField;

    @FXML
    private Label orderLabel;

    @FXML
    private Label getAllAMountLabel;

    @FXML
    void initialize() {
        backFiled.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backFiled);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        orderFind.setOnAction(actionEvent -> {
            Integer idOrder = Integer.parseInt(orderFindField.getText());
            if (idOrder <= fasadOrder.showAllOrder().size() && idOrder > 0) {
                orderLabel.setText(fasadOrder.findByID(idOrder).toString());
                getAllAMountLabel.setText(fasadOrder.getAllAmount(idOrder).toString());
            } else orderLabel.setText("Order not found");
        });

    }

    FasadOrder fasadOrder = FasadOrder.getInstance();
    private String backFieldPath = "/resources/Main.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }
}

