package interfaceController;

import javafx.scene.control.Button;

import java.io.IOException;

public interface IController {
    void openNewScene(String path, Button button) throws IOException;
}
