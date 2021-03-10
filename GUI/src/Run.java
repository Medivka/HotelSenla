import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Run extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)  {
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource("resourses/Main.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Grand Hotel Senla");
        primaryStage.setScene(new Scene(root,445,590));
        primaryStage.show();
    }
}
