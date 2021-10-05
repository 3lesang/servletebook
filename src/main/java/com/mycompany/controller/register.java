package com.mycompany.controller;


import com.mycompany.dao.DAO;
import com.mycompany.model.User;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public register() {
            super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repw = request.getParameter("repw");
        User newUser = new User(name, username, password);

        DAO dao = new DAO();
        if(password.equals(repw)) {
            if(dao.insertUser(newUser)){
                response.sendRedirect("login");
            } else {
                response.sendRedirect("register");
            }
        } else {
            response.sendRedirect("register");
        }	
    }
}