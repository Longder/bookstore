package com.longder.bookstore.web;

import com.longder.bookstore.dao.CartDetailDao;
import com.longder.bookstore.entity.CartDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 展示购物车用的Servlet
 */
public class ShowCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //查询购物车中的所有内容
        CartDetailDao cartDetailDao = new CartDetailDao();
        List<CartDetail> detailList = cartDetailDao.listAll();

        //计算总价
        Double total = 0D;
        for (CartDetail detail : detailList) {
            total += detail.getPrice();
        }
        request.setAttribute("total", total);
        request.setAttribute("detailList", detailList);


        request.getRequestDispatcher("/showCart.jsp").forward(request, response);
    }
}
