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
        System.out.println("进入Servlet");

        //检查这个用户登录了没，没有登陆就去登录页
        //查询所有图书
        BookDao bookDao = new BookDao();
        List<Book> bookList = bookDao.listAll();

        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("/showAllBook.jsp").forward(req, resp);
    }
}
