package com.longder.bookstore.web;

import com.longder.bookstore.dao.UserDao;
import com.longder.bookstore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册用的servlet
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String loginName = request.getParameter("loginName");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao userDao = new UserDao();
        //检查登录名是否存在
        User user = userDao.getByLoginName(loginName);
        if (user != null) {
            request.setAttribute("message", "登录名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            user = new User();
            user.setLoginName(loginName);
            user.setName(name);
            user.setPassword(password);
            //类型set为普通用户
            user.setType("user");
            userDao.add(user);
            request.setAttribute("message", "注册成功");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
