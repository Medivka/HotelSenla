package loggerConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public class CustomLogger {
    static {
        try (InputStream configReader = new FileInputStream("Hotel/resourses/logger.properties")) {
            LogManager.getLogManager().readConfiguration(configReader);
        }catch (IOException e){
            System.err.println("not setup logger configuration");
        }
    }
}
