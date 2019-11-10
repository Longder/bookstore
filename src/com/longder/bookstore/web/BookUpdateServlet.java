package com.longder.bookstore.web;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Long id = Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));

        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setPrice(price);

        BookDao bookDao = new BookDao();
        bookDao.update(book);

        //重定向回列表页
        response.sendRedirect(request.getContextPath()+"/listBook");
    }
}
