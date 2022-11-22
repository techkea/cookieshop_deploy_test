package com.example.jar_cookie.repositories;

import com.example.jar_cookie.models.Cookie;
import com.example.jar_cookie.repositories.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CookieDBRepository {

    Connection conn = DatabaseConnectionManager.getConnection();
    List<Cookie> cookies;

    public List<Cookie> getAllCookies(){

        cookies = new ArrayList<>();

        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * from cookies");
            ResultSet resultSet = psts.executeQuery();
            while(resultSet.next()){
                cookies.add(new Cookie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cookies;
    }

    public Cookie getCookieById(int id){
        try {
            PreparedStatement psts = conn.prepareStatement("SELECT * from cookies WHERE id = ?");
            psts.setInt(1 , id);
            ResultSet resultSet = psts.executeQuery();

            if(resultSet.next()){
                return new Cookie(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
