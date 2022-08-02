package com.Login.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement; 
import com.Login.model.UserLogin;
import com.Login.util.DBConnection;
 
public class DAOClass {
 
public String authenticateUser(UserLogin ul)
{
    long aadhar = ul.getAadhar();
    String password = ul.getPassword();
    String role= ul.getRole();
 
    Connection con = null;
    Statement statement = null;
    ResultSet resultSet = null;
 
    long useridDB;
    String passwordDB = "";
    String roleDB = "";
 
    try
    {
        con = DBConnection.createConnection();
        statement = con.createStatement();
        resultSet = statement.executeQuery("select aadhar,password,role from user");
 
        while(resultSet.next())
        {
            useridDB = resultSet.getLong("aadhar");
            passwordDB = resultSet.getString("password");
            roleDB = resultSet.getString("role");
 
            if(aadhar==(useridDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
            return "Admin_Role";
            else if(aadhar==(useridDB) && password.equals(passwordDB) && roleDB.equals("User"))
            return "User_Role";
        }
    }
    catch(SQLException e)
    {
        e.printStackTrace();
    }
    return "Invalid user credentials";
}
public boolean display(long aadhar ) {
	 Connection conn = DBConnection.createConnection();
	PreparedStatement pstmt = null;
	String sql = "SELECT * FROM user WHERE aadhar = ?";
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, aadhar);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		
		while (rs.next()) {
			StringBuilder sb = new StringBuilder();
			
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				String colName = rsmd.getColumnName(i);
				
				sb.append(rs.getObject(colName));
				if (i != rsmd.getColumnCount()) sb.append(", ");
			}
			System.out.println(sb);
		}
		
		return true;
	} catch (SQLException e) {
		return false;
	}
}
}
