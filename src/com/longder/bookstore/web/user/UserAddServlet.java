package com.longder.bookstore.web.user;

import com.longder.bookstore.dao.UserDao;
import com.longder.bookstore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加用户的Servlet
 */
public class UserAddServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String loginName = request.getParameter("loginName");
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = new User();
        user.setLoginName(loginName);
        user.setName(name);
        user.setPassword(password);
        user.setType("user");

        UserDao userDao = new UserDao();
        User u1 = userDao.getByLoginName(loginName);
        if(u1!=null){
            request.setAttribute("message", "登录名已存在");
            request.getRequestDispatcher("/addUser.jsp").forward(request, response);
        }else{
            userDao.add(user);
            //重定向回列表页
            response.sendRedirect(request.getContextPath() + "/listUser");
        }

    }
}
