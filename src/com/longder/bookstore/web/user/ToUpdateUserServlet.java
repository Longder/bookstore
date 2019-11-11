package com.longder.bookstore.web.user;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.dao.UserDao;
import com.longder.bookstore.entity.Book;
import com.longder.bookstore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 去用户修改页的Servlet
 */
public class ToUpdateUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Long userId = Long.valueOf(request.getParameter("id"));

        UserDao userDao = new UserDao();
        User user = userDao.getById(userId);

        request.setAttribute("user",user);
        request.getRequestDispatcher("/updateUser.jsp").forward(request,response);
    }
}
