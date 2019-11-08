package com.longder.bookstore.dao;

import com.longder.bookstore.entity.Book;
import com.longder.bookstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Book表的数据库交互对象
 */
public class BookDao {

    /**
     * 查询所有图书
     *
     * @return
     */
    public List<Book> listAll() {
        List<Book> bookList = new ArrayList<>();

        Connection connection = DBUtil.getConnection();

        String sql = "SELECT * FROM BOOK";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getLong("id_"));
                book.setName(resultSet.getString("name_"));
                book.setPrice(resultSet.getDouble("price_"));
                bookList.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return bookList;
    }

    /**
     * 根据id查询一本图书
     *
     * @return
     */
    public Book getById(Long bookId) {
        Book book = null;
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT * FROM BOOK WHERE id_ = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, bookId);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                book = new Book();
                book.setId(resultSet.getLong("id_"));
                book.setName(resultSet.getString("name_"));
                book.setPrice(resultSet.getDouble("price_"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return book;
    }
}
