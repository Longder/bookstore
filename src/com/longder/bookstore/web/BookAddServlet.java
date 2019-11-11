package com.longder.bookstore.web;

import com.longder.bookstore.dao.BookDao;
import com.longder.bookstore.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


@MultipartConfig
public class BookAddServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//        //创建一个解析器工厂
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        //文件上传解析器
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        // 判断enctype属性是否为multipart/form-data
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//        if (isMultipart) {
//            //解析请求，将表单中每个输入项封装成一个FileItem对象
//            List<FileItem> fileItems = upload.parseRequest(request.getServletContext());
//        }

        String name = request.getParameter("name");
        Double price = Double.valueOf(request.getParameter("price"));
        Part p = request.getPart("image");
        //图片存储为base64
        String image = "data:image/jpeg;base64," + DatatypeConverter.printBase64Binary(toByteArray(p.getInputStream()));
        BookDao bookDao = new BookDao();
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setImage(image);
        bookDao.add(book);
        //重定向回列表页
        response.sendRedirect(request.getContextPath() + "/listBook");
    }

    private byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}
