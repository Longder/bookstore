package com.longder.bookstore.web.user;

import com.longder.bookstore.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除用户的Servlet
 */
public class UserDeleteServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        UserDao userDao = new UserDao();

        Long userId = Long.valueOf(request.getParameter("id"));
        userDao.delete(userId);
        //重定向到用户列表页
        response.sendRedirect(request.getContextPath()+"/listUser");
    }
}
