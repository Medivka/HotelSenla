package com.databaseControllers;

import com.configsDB.ConfigDB;
import com.configsDB.Constants;
import com.dao.GuestDao;
import com.model.Guest;
import com.model.Order;
import com.service.GuestService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return dbConnection;
    }

}
