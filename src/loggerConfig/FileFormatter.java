package loggerConfig;

import java.util.logging.Logger;

public class FileFormatter {
    private static Logger LOGGER;
    static {
        System.setProperty("java.util.logging.config.file",
                "logger.properties");

        LOGGER = Logger.getLogger(FileFormatter.class.getName());
    }
    public FileFormatter(){

    }
    public static void main(String[] args) {

        LOGGER.info("Info");
        LOGGER.warning("Warning");
        LOGGER.severe("Massege");
    }

}
