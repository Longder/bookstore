package com.longder.bookstore.web;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.dao.CartDetailDao;
import com.longder.bookstore.entity.Book;
import com.longder.bookstore.entity.CartDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加进购物车的Servlet
 */
public class AddServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取表单提交的参数
        Long bookId = Long.valueOf(request.getParameter("bookId"));
        Integer count = Integer.valueOf(request.getParameter("count"));

        BookDao bookDao = new BookDao();
        Book book = bookDao.getById(bookId);

        CartDetail cartDetail = new CartDetail();
        cartDetail.setBookId(bookId);
        cartDetail.setCount(count);
        cartDetail.setPrice(book.getPrice() * count);

        CartDetailDao cartDetailDao = new CartDetailDao();
        cartDetailDao.add(cartDetail);

        response.sendRedirect("/showCart");
    }
}
