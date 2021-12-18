package com.mycompany.controller.auth;



import com.mycompany.dao.UserDAO;
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
    private final UserDAO userDAO;
    public register() {
            super();
            this.userDAO = new UserDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String repw = request.getParameter("repw");
        User newUser = new User(name, username, password,"useravatar.png", "user");
        
        if(password.equals(repw)) {
            if(this.userDAO.insertUser(newUser)){
                response.sendRedirect("login");
            } else {
            	request.setAttribute("mess", "Không thể tạo tài khoản");

                RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("mess", "Mật khẩu nhập lại không hợp lệ");

            RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }	
    }
}