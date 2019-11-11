package com.longder.bookstore.web.user;

import com.longder.bookstore.dao.UserDao;
import com.longder.bookstore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 更新用户的Servlet
 */
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Long id = Long.valueOf(request.getParameter("id"));
        String loginName = request.getParameter("loginName");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = new User();
        user.setId(id);
        user.setLoginName(loginName);
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new UserDao();
        userDao.update(user);


        //重定向回列表页
        response.sendRedirect(request.getContextPath() + "/listUser");

    }
}
