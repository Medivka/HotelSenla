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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FindGuestController implements IController {

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
    private Label labelGuestFind;
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
            Integer guestId = Integer.parseInt(id.getText());
            if(guestId<=fasadGuest.showAllGuests().size()&&guestId>0){
                labelGuestFind.setText(fasadGuest.findById(guestId).toString());}else labelGuestFind.setText("Guest not found");
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
