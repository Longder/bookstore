package com.longder.bookstore.web;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 后台图书列表的servlet
 */
public class BookListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        //查询所有的图书
        List<Book> bookList = bookDao.listAll();
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/listBook.jsp").forward(request, response);
    }
}
