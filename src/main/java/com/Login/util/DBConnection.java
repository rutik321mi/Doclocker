package com.Login.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
 
    public static Connection createConnection()
    {
    	
    	 Connection con=null;
 
    try
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
        
    }
    catch (SQLException e)
        {
           System.out.println("An error occurred. Maybe user/password is invalid");
         e.printStackTrace();
       }
    return con;
    }
}