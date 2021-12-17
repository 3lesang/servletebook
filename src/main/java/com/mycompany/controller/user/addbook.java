package com.mycompany.controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.dao.BookDAO;
import com.mycompany.model.Book;
import com.mycompany.model.User;

@WebServlet(name = "addbook", urlPatterns = {"/dashboard/addbook"})
public class addbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDAO bookDAO;
    public addbook() {
        super();
        this.bookDAO = new BookDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/editBook.jsp");
        rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("userInfo");
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
        String img = request.getParameter("img");
        String detail = request.getParameter("detail");
        Book book = new Book(title, img, 0, user, detail);
        boolean inserted = this.bookDAO.insertBook(book);
        if(inserted) {
            response.sendRedirect("/ebook/dashboard");
        }
	}

}
