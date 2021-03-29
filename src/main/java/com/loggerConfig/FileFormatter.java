package com.loggerConfig;

import com.sun.tools.javac.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class FileFormatter {
    private static Logger LOGGER;
    static {
        try (InputStream configReader = new FileInputStream("resources/logger.properties")) {
            LogManager.getLogManager().readConfiguration(configReader);
            LOGGER = Logger.getLogger(Main.class.getName());
        } catch (IOException e) {
            System.err.println("not setup logger configuration");
        }
    }
    public static void main(String[] args) {

        LOGGER.info("Info");
        LOGGER.warning("Warning");
        LOGGER.severe("Massege");
    }

}