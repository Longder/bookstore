package com.longder.bookstore.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登出操作的servlet
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //清空session中的用户信息
        request.getSession().setAttribute("user",null);
        //重定向到主页
        response.sendRedirect(request.getContextPath()+"/index");
    }
}
