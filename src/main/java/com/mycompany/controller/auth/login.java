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
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    private UserDAO userDAO;
    public login() {
        super();
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = this.userDAO.login(username, password);
        if(user != null) {
            HttpSession session = request.getSession();  
            session.setAttribute("userInfo",user);  
            response.sendRedirect("home");
            
        } else {
        	request.setAttribute("mess", "Không thể đăng nhập");

            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
        

    }

}