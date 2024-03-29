


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import springConfig.SpringBeans;

import java.io.IOException;

/**
 * install JavaFX
 * <p>
 * Edit configuration... -> VM option
 * <p>
 * and write
 * <p>
 * --module-path
 * C:\javafx-sdk-11.0.2\lib    - path to libraries
 * --add-modules
 * javafx.controls,javafx.fxml
 */

public class Run extends Application {

    public static void main(String[] args) {

        SpringBeans.init();
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Grand Hotel Senla");
        primaryStage.setScene(new Scene(root, 1362, 924));
        primaryStage.show();
    }
}
