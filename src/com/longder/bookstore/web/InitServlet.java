package com.longder.bookstore.web;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class InitServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");


        String bookName = req.getParameter("bookName");
        //查询所有图书
        BookDao bookDao = new BookDao();
        List<Book> bookList = bookDao.listAll(bookName);

        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("/showAllBook.jsp").forward(req, resp);
    }
}
