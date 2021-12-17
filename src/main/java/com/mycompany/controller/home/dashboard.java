package com.mycompany.controller.home;

import com.mycompany.dao.BookDAO;
import com.mycompany.dao.UserDAO;
import com.mycompany.model.Book;
import com.mycompany.model.User;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "dashboard", urlPatterns = {"/dashboard"})
public class dashboard extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public dashboard() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	User user = (User) request.getSession().getAttribute("userInfo");
    	String role = user.getRole();
    	int id = user.getId();
    	BookDAO bookDAO = new BookDAO();
    	List<Book> books;
    	if(role.equals("admin")) {
    		UserDAO userDAO = new UserDAO();		
    		List<User> users = userDAO.getAllUsers();
    		books = bookDAO.getAllBooks();
    		request.setAttribute("users", users);
            
    	} else {
    		books = bookDAO.getBooksByAuthor(id);
    	}
    	request.setAttribute("books", books);

        RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
        rd.forward(request, response);
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
    }


}
