package com.mvc.controller;

import com.mvc.bean.User;
import com.mvc.dao.LoginDao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        if(request.getParameter("btn_login")!=null) //check button click event not null from login.jsp page button
        {
            String username=request.getParameter("txt_username"); //get textbox name "txt_username"
            String password=request.getParameter("txt_password"); //get textbox name "txt_password"
            
            User userBean=new User(); //this class contain seeting up all received values from index.jsp page to setter and getter method for application require effectively 
            
            userBean.setUsername(username); //set username through userBean object
            userBean.setPassword(password); //set password through userBean object
            
            LoginDao loginDao=new LoginDao(); //this class contain main logic to perform function calling and database operation
            
            String authorize=loginDao.authorizeLogin(userBean); //send userBean object values into authorizeLogin() function in LoginDao class
            
            if(authorize.equals("SUCCESS LOGIN")) //check calling authorizeLogin() function receive string "SUCCESS LOGIN" message after continue process
            {
                HttpSession session=request.getSession(); //session is created
                session.setAttribute("role",userBean.getRole());
                session.setAttribute("name",userBean.getName());
                session.setAttribute("login",userBean.getUsername()); //session name is "login" and  store username in "getUsername()" get through userBean object
                String path = "welcome.jsp";
                if(userBean.getRole().equals("manager"))
                    path = "manager.jsp";
                RequestDispatcher rd=request.getRequestDispatcher(path); //redirect to welcome.jsp page
                rd.forward(request, response);
            }
            else
            {
                request.setAttribute("WrongLoginMsg",authorize); //wrong login error message is "WrongLoginMsg"
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp"); //show error same index.jsp page
                rd.include(request, response);
            }
        }
    }

}
