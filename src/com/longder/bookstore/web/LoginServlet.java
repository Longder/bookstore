package com.longder.bookstore.web;

import com.longder.bookstore.dao.UserDao;
import com.longder.bookstore.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆用的Servlet
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");

        UserDao userDao = new UserDao();
        User user = userDao.getByLoginName(loginName);
        if(user!=null&&user.getPassword().equals(password)){
            //登陆成功后，用户信息写入session
            request.getSession().setAttribute("user",user);
            //去主页
            response.sendRedirect(request.getContextPath()+"/index");
        }else{
            request.setAttribute("message","用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
