package com.mvc.dao;

import com.mvc.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao 
{
    public String authorizeLogin(User userBean) //create authorizeLogin()function
    {
        String username=userBean.getUsername(); //get username value through userBean object and store in temporary variable "username"
        String password=userBean.getPassword(); //get password value through userBean object and store in temporary variable "password"
        
        String dbusername="";  //create two variable for use next process
        String dbpassword="";
        String dbrole="";
        String dbname="";
        
        String url="jdbc:mysql://localhost:3306/db_mvclogin?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8"; //database connection url string
        String uname="root"; //database username
        String pass="password"; //database password
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); //load driver
            Connection con=DriverManager.getConnection(url,uname,pass); //create connection
            
            PreparedStatement pstmt=null; //create statement
            
            pstmt=con.prepareStatement("select * from user where username=? and password=?"); //sql select query 
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery(); //execute query and set in Resultset object rs.
            
            while(rs.next())
            {    
                dbusername=rs.getString("username");   //fetchable database record username and password store in this two variable dbusername,dbpassword above created 
                dbpassword=rs.getString("password"); 
                dbrole=rs.getString("role");
                dbname=rs.getString("name");
                userBean.setRole(dbrole);
                userBean.setName(dbname);
                
                if(username.equals(dbusername) && password.equals(dbpassword))  //apply if condition check for fetchable database username and password are match for user input side type in textbox
                {
                    return "SUCCESS LOGIN"; //if valid condition return string "SUCCESS LOGIN" 
                }
            } 
           
            pstmt.close(); //close statement
            
            con.close(); //close connection
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return "Invalid userid or password"; //if invalid condition return string "Invalid userid or passwor"
    }
}
