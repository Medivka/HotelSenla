package controllers.orderControllers;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import api.IController;
import fasad.FasadGuest;
import fasad.FasadOrder;
import fasad.FasadRoom;
import fasad.FasadService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Guest;
import model.Service;

public class UpdateOrderController implements IController {

    @FXML
    private Button backField;

    @FXML
    private TextField guestIdField;

    @FXML
    private Button changeDaysOfStayButton;

    @FXML
    private TextField daysOfStayField;

    @FXML
    private Button createNewGuest;

    @FXML
    private Button findGuest;

    @FXML
    private Label findGuestLabel;

    @FXML
    private TextField nameGuest;

    @FXML
    private TextField ageGuest;

    @FXML
    private Label findRoomLabel;

    @FXML
    private TextField serviceIdField;

    @FXML
    private Button findService;

    @FXML
    private Label findServiceLabel;

    @FXML
    private TextField nameService;

    @FXML
    private TextField priceService;

    @FXML
    private Button createNewService;

    @FXML
    private Label dataLabel;

    @FXML
    private Label orderLabel;

    @FXML
    private Button addGuestButton;

    @FXML
    private Button addServiceButton;

    @FXML
    private TextField findOrderFiled;

    @FXML
    private Button findOrder;

    @FXML
    private TextField roomIdField;

    @FXML
    private Button changeRoomButton;

    @FXML
    void initialize() {
        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        findOrder.setOnAction(actionEvent -> {
            Integer idOrder = Integer.parseInt(findOrderFiled.getText());
            if (idOrder <= fasadOrder.showAllOrder().size() && idOrder > 0) {

                orderLabel.setText(fasadOrder.findByID(idOrder).toString());
            } else orderLabel.setText("Order not found");
        });
        findService.setOnAction(actionEvent -> {
            Integer serviceId = Integer.parseInt(serviceIdField.getText());
            if (serviceId <= fasadService.showAllService().size() && serviceId > 0) {
                findServiceLabel.setText(fasadService.findByID(serviceId).toString());
            } else findServiceLabel.setText("Service not found");
        });
        createNewService.setOnAction(actionEvent -> {
            String name = nameService.getText();
            Integer price = Integer.parseInt(priceService.getText());
            Service service = fasadService.createNewService(name, price);
            serviceIdField.setText(service.getId().toString());
            findServiceLabel.setText(service + " created");
        });
        addServiceButton.setOnAction(actionEvent -> {
            fasadOrder.AddInRoomService(Integer.parseInt(findOrderFiled.getText()), fasadService.findByID(Integer.parseInt(serviceIdField.getText())));
            orderLabel.setText(fasadOrder.findByID(Integer.parseInt(findOrderFiled.getText())).toString());
        });
        findGuest.setOnAction(actionEvent -> {
            Integer guestId = Integer.parseInt(guestIdField.getText());
            if (guestId <= fasadGuest.showAllGuests().size() && guestId > 0) {
                findGuestLabel.setText(fasadGuest.findById(guestId).toString());
            } else findGuestLabel.setText("Guest not found");
        });
        createNewGuest.setOnAction(actionEvent -> {
            String name = nameGuest.getText();
            Integer age = Integer.parseInt(ageGuest.getText());
            Guest guest = fasadGuest.createNewGuest(name, age);
            guestIdField.setText(guest.getGuestNumber().toString());
            findGuestLabel.setText(guest.toString() + "  created");

        });
        addGuestButton.setOnAction(actionEvent -> {
            fasadOrder.addGuestInRoom(Integer.parseInt(findOrderFiled.getText()), fasadGuest.findById(Integer.parseInt(guestIdField.getText())));
            orderLabel.setText(fasadOrder.findByID(Integer.parseInt(findOrderFiled.getText())).toString());
        });
        changeRoomButton.setOnAction(actionEvent -> {
            fasadOrder.changeRoomInOrder(Integer.parseInt(findOrderFiled.getText()),fasadRoom.findById(Integer.parseInt(roomIdField.getText())));
            orderLabel.setText(fasadOrder.findByID(Integer.parseInt(findOrderFiled.getText())).toString());

        });
        changeDaysOfStayButton.setOnAction(actionEvent -> {
            fasadOrder.changeDaysOfStay(Integer.parseInt(findOrderFiled.getText()), Integer.parseInt(daysOfStayField.getText()));
            orderLabel.setText(fasadOrder.findByID(Integer.parseInt(findOrderFiled.getText())).toString());
        });
    }

    FasadService fasadService = FasadService.getInstance();
    FasadGuest fasadGuest = FasadGuest.getInstance();
    FasadRoom fasadRoom = FasadRoom.getInstance();
    FasadOrder fasadOrder = FasadOrder.getInstance();

    private String backFieldPath = "/resources/orderMenu.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }

}
