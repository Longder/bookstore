package com.longder.bookstore.web;

import com.longder.bookstore.dao.CartDetailDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 移除购物车的Servlet
 */
public class RemoveServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //获取购物车id
        Long id = Long.valueOf(request.getParameter("id"));

        CartDetailDao cartDetailDao = new CartDetailDao();
        cartDetailDao.remove(id);

        response.sendRedirect("/showCart");
    }
}
