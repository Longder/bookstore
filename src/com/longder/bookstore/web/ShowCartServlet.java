package com.longder.bookstore.web;

import com.longder.bookstore.dao.CartDetailDao;
import com.longder.bookstore.entity.CartDetail;
import com.longder.bookstore.entity.User;

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

        //查询当前登录用户购物车中的所有内容
        CartDetailDao cartDetailDao = new CartDetailDao();
        Long userId = ((User)request.getSession().getAttribute("user")).getId();
        List<CartDetail> detailList = cartDetailDao.listByUserId(userId);

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
