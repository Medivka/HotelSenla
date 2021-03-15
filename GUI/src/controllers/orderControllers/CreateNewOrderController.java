package controllers.orderControllers;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import api.IController;
import api.enums.RoomStatus;
import fasad.FasadGuest;
import fasad.FasadOrder;
import fasad.FasadRoom;
import fasad.FasadService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Guest;
import model.Room;
import model.Service;

public class CreateNewOrderController implements IController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backField;

    @FXML
    private TextField guestIdField;

    @FXML
    private TextField roomIdField;
    @FXML
    private Button createNewOrder;

    @FXML
    private Button createNewService;

    @FXML
    private TextField daysOfStayField;

    @FXML
    private Button createNewGuest;

    @FXML
    private Button findRoom;

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
    private Label dataLabel;

    @FXML
    private TextField priceField;

    @FXML
    private TextField capacityField;

    @FXML
    private ComboBox<Integer> starsCombo;

    @FXML
    private ComboBox<RoomStatus> statusCombo;

    @FXML
    private Button createNewRoom;
    @FXML
    private Label orderLabel;


    @FXML
    void initialize() {
        LocalDate localDate= LocalDate.now();
        dataLabel.setText(String.valueOf(localDate));
        starsCombo.getItems().addAll(1, 2, 3, 4, 5);
        statusCombo.getItems().addAll(RoomStatus.FREE, RoomStatus.BUSY, RoomStatus.REPAIRS);


        backField.setOnAction(actionEvent -> {
            try {
                openNewScene(backFieldPath, backField);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            Guest guest=fasadGuest.createNewGuest(name,age);
            guestIdField.setText(guest.getGuestNumber().toString());
            findGuestLabel.setText(guest+ "  created");

        });
        findRoom.setOnAction(actionEvent -> {
            Integer roomID = Integer.parseInt(roomIdField.getText());
            if (roomID <= fasadRoom.showAllRoom().size() && roomID > 0) {
                findRoomLabel.setText(fasadRoom.findById(roomID).toString());
            } else findRoomLabel.setText("room not found");
        });
        createNewRoom.setOnAction(actionEvent -> {

            Integer price = Integer.parseInt(priceField.getText());
            Integer capacity = Integer.parseInt(capacityField.getText());
            Integer stars = starsCombo.getValue();
            RoomStatus roomStatus = statusCombo.getValue();
            Room room=fasadRoom.createRoom(roomStatus, capacity, price, stars);
            roomIdField.setText(room.getRoomNumber().toString());
            findRoomLabel.setText(room + " created");
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
            Service service=fasadService.createNewService(name,price);
            serviceIdField.setText(service.getId().toString());
            findServiceLabel.setText(service + " created");
        });
        createNewOrder.setOnAction(actionEvent ->
                orderLabel.setText(fasadOrder.createNewOrder(
                        fasadGuest.findById(Integer.parseInt(guestIdField.getText())),
                        fasadRoom.findById(Integer.parseInt(roomIdField.getText())),
                        fasadService.findByID(Integer.parseInt(serviceIdField.getText())),
                        localDate,
                        Integer.parseInt(daysOfStayField.getText())).toString()));
        };

    FasadService fasadService = FasadService.getInstance();
    FasadGuest fasadGuest = FasadGuest.getInstance();
    FasadRoom fasadRoom = FasadRoom.getInstance();
    FasadOrder fasadOrder = FasadOrder.getInstance();

    private String backFieldPath = "/resources/Main.fxml";

    @Override
    public void openNewScene(String path, Button button) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root, 445, 590));
    }


}

