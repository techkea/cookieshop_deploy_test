package com.example.jar_cookie.repositories.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private static String hostname;
    private static String username;
    private static String password;
    private static Connection conn;

    private DatabaseConnectionManager() {}

    public static Connection getConnection(){
        if(conn != null){
            return conn;
        }

        //hostname = "jdbc:mysql://eu-central.connect.psdb.cloud/clbotest";
        //username = "k88vwmzb25vweuyspztc";
        //password = "pscale_pw_80ddEXgIbUVny5E2TCrOdhvUil8uzngZ3lImcPLH46c";


        hostname = System.getenv("host");
        username = System.getenv("user");
        password = System.getenv("pass");

        try {
            conn = DriverManager.getConnection(hostname, username, password);
            System.out.println("Connected to DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
