package com.mycompany.controller.admin;

import com.mycompany.dao.UserDAO;
import com.mycompany.model.User;
import com.mycompany.dao.BookDAO;
import com.mycompany.model.Book;
import com.mycompany.util.HibernateUtil;

import java.io.IOException;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

@WebServlet(name = "manageuser", urlPatterns = {"/admin1"})
public class manageuser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private List<User> users;
	private UserDAO userDAO;
	public manageuser() {
		super();
		this.userDAO = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.users = this.userDAO.getAllUsers();
		request.setAttribute("users", this.users);
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}
    
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
    }
}