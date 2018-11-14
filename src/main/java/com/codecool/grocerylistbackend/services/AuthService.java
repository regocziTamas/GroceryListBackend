package com.codecool.grocerylistbackend.services;

import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class AuthService {

    public void registerNewId(String id){

        final String JDBC_DRIVER = "org.postgresql.Driver";
        final String DB_URL = System.getenv("JDBC_DATABASE_URL");
        final String USER = System.getenv("JDBC_DATABASE_USERNAME");
        final String PASS = System.getenv("JDBC_DATABASE_PASSWORD");


        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.prepareStatement("INSERT INTO uuids (uuid) VALUES  (?)");
            stmt.setString(1,id);



        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }

        }
    }
}


