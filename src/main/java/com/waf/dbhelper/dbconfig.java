package com.waf.dbhelper;

import com.common.utilities.ConfigLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbconfig {

    static ConfigLoader configLoader;

    static {
        try {
            configLoader = new ConfigLoader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Database connection details
    private static final String DB_HOST = configLoader.getProperty("DB_HOST");
    private static final int DB_PORT = Integer.parseInt(configLoader.getProperty("DB_PORT"));
    private static final String DB_USER = configLoader.getProperty("DB_USER");
    private static final String DB_PASSWORD = configLoader.getProperty("DB_PASSWORD");
    private static final String DB_NAME = configLoader.getProperty("DB_NAME");

    private static final String JDBC_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    static Connection conn = null;

    public static void initilizeDb() {
        try {
            conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database", e);
        }
        System.out.println("Database connection established successfully");
    }

    public static void closeDriver() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Database connection closed successfully");
    }

    public static ResultSet executeQuery(String sqlQuery) {
        ResultSet rs = null;
        try {
            initilizeDb();
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            System.out.println("Executed query: " + sqlQuery);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // or handle accordingly
        }
    }

    public static int executeUpdate(String sqlQuery) {
        int result = 0;
        try {
            initilizeDb();
            PreparedStatement stmt = conn.prepareStatement(sqlQuery);
            result = stmt.executeUpdate();
            System.out.println("Executed update: " + sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
