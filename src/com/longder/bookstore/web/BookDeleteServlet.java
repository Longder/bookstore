package com.longder.bookstore.web;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.dao.CartDetailDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Long bookId = Long.valueOf(request.getParameter("id"));

        //先删除购物车中存在的此图书
        CartDetailDao cartDetailDao = new CartDetailDao();
        cartDetailDao.removeByBook(bookId);

        //再删除图书
        BookDao bookDao = new BookDao();
        bookDao.delete(bookId);

        //重定向回列表页
        response.sendRedirect(request.getContextPath()+"/listBook");
    }
}
