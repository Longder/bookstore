package com.longder.bookstore.web;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 去购买商品页的servlet
 */
public class BuyFormServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取请求参数
        Long bookId = Long.valueOf(request.getParameter("id"));

        BookDao bookDao = new BookDao();
        //查询图书
        Book book = bookDao.getById(bookId);

        request.setAttribute("book", book);

        request.getRequestDispatcher("/buyForm.jsp").forward(request, response);

    }
}
