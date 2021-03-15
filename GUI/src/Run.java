import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * install JavaFX
 *
 * Edit configuration -> VM option
 *
 * and write
 *
 * --module-path
 * C:\javafx-sdk-11.0.2\lib    - path to libraries
 * --add-modules
 * javafx.controls,javafx.fxml
 */

public class Run extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent  root= FXMLLoader.load(getClass().getResource("resources/Main.fxml"));

        primaryStage.setTitle("Grand Hotel Senla");
        primaryStage.setScene(new Scene(root,445,590));
        primaryStage.show();
    }
}
