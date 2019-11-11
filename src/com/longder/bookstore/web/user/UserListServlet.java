package com.longder.bookstore.web.user;

import com.longder.bookstore.dao.UserDao;
import com.longder.bookstore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 用户列表的Servlet
 */
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        UserDao userDao = new UserDao();

        List<User> userList = userDao.listAllUser();

        request.setAttribute("userList", userList);
        request.getRequestDispatcher("/listUser.jsp").forward(request, response);
    }
}
