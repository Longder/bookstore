package com.longder.bookstore.web;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 去更新图书页的Servlet
 */
public class ToUpdateBookServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Long bookId = Long.valueOf(request.getParameter("id"));

        BookDao bookDao = new BookDao();
        Book book = bookDao.getById(bookId);
        request.setAttribute("book",book);
        request.getRequestDispatcher("/updateBook.jsp").forward(request,response);
    }
}
