package com.mycompany.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.dao.UserDAO;
import com.mycompany.model.User;

@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private User user;
	private UserDAO userDAO; 
    public profile() {
        super();
        this.userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("u");
		this.user = this.userDAO.getUserByUsername(username);
        request.setAttribute("user", this.user);
        RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");  
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userSession = (User) request.getSession().getAttribute("userInfo");
		UserDAO userDAO = new UserDAO();
		String currentPassword = request.getParameter("currentPassword");
		String password = request.getParameter("password");
		User userInDB = (User) userDAO.getUserByUsername(userSession.getUsername());
		
		if(userInDB.getPword().equals(currentPassword)) {
			userDAO.changePass(userInDB.getUsername(), password);
			request.setAttribute("messChangePass", "Thay đổi mật khẩu thành công");
		} else {
			request.setAttribute("messChangePass", "Mật khẩu chưa chính xác");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
        rd.forward(request, response);
		
	}

}
