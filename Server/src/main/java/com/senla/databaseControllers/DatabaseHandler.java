package com.senla.databaseControllers;



import com.senla.configsDB.ConfigDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends ConfigDB {
   private static DatabaseHandler instance;


    public static DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
        }
        return instance;
    }

  Connection dbConnection;

    public Connection getDbConnection(){
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        try {
            dbConnection= DriverManager.getConnection(connectionString,dbUser,dbPassword);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return dbConnection;
    }

}
