package com.longder.bookstore.dao;

import com.longder.bookstore.entity.Book;
import com.longder.bookstore.util.DBUtil;
import com.sun.corba.se.impl.orb.PrefixParserAction;

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

    /**
     * 添加一本图书
     * @param book
     */
    public void add(Book book){
        Connection connection = DBUtil.getConnection();
        String sql = "INSERT INTO book(name_, price_) VALUES(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,book.getName());
            ps.setDouble(2,book.getPrice());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
    }

    /**
     * 更新一本图书
     * @param book
     */
    public void update(Book book){
        Connection connection = DBUtil.getConnection();
        String sql = "UPDATE book SET name_ = ?,price_=? where id_ = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,book.getName());
            ps.setDouble(2,book.getPrice());
            ps.setLong(3,book.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
    }

    /**
     * 删除图书
     * @param bookId
     */
    public void delete(Long bookId){
        Connection connection = DBUtil.getConnection();

        String sql = "DELETE from book where id_ = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,bookId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
    }
}
