package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mvc.bean.User;

public class RegisterDao 
{
    public String authorizeRegister(User userBean) //create authorizeRegister()function
    {
        String fname=userBean.getName();
        String role=userBean.getRole();
        String username=userBean.getUsername();  //get all value through userBean object and store in temporary variable
        String password=userBean.getPassword();
        
        String url="jdbc:mysql://localhost:3306/db_mvclogin?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8"; //database connection url string
        String uname="root"; //database username
        String pass="password"; //database password
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmt=null; //create statement
            pstmt=con.prepareStatement("select * from user where username=?"); //sql insert query
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery(); //don't allow duplicate username
            if(rs.next())
            {
                return "FAIL REGISTER";
            }
            pstmt=con.prepareStatement("insert into user(name,role,username,password) values(?,?,?,?)"); //sql insert query
            pstmt.setString(1,fname);
            pstmt.setString(2,role);
            pstmt.setString(3,username);
            pstmt.setString(4,password); 
            pstmt.executeUpdate(); //execute query
             
            pstmt.close(); //close statement
            
            con.close(); //close connection
           
            return "SUCCESS REGISTER"; //if valid return string "SUCCESS REGISTER" 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            return "FAIL REGISTER"; //if invalid return string "FAIL REGISTER"
    }
}
