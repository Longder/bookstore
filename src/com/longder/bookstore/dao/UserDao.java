package com.longder.bookstore.dao;

import com.longder.bookstore.entity.User;
import com.longder.bookstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User表的数据库交互对象
 */
public class UserDao {

    /**
     * 根据登录名检查用户
     *
     * @param loginName
     * @return
     */
    public User getByLoginName(String loginName) {
        User user = null;
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT * FROM sys_user WHERE login_name_ = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, loginName);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id_"));
                user.setLoginName(resultSet.getString("login_name_"));
                user.setName(resultSet.getString("name_"));
                user.setPassword(resultSet.getString("password_"));
                user.setType(resultSet.getString("type_"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return user;
    }

    /**
     * 添加一个用户
     *
     * @param user
     */
    public void add(User user) {
        Connection connection = DBUtil.getConnection();
        String sql = "INSERT INTO sys_user(name_, login_name_, password_,type_) values(?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLoginName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getType());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> listAllUser() {
        List<User> userList = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT * FROM sys_user";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id_"));
                user.setLoginName(resultSet.getString("login_name_"));
                user.setName(resultSet.getString("name_"));
                user.setPassword(resultSet.getString("password_"));
                user.setType(resultSet.getString("type_"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return userList;
    }

    /**
     * 删除一个用户
     *
     * @param userId
     */
    public void delete(Long userId) {
        Connection connection = DBUtil.getConnection();
        String sql = "DELETE FROM sys_user WHERE id_ = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, userId);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    /**
     * 根据id查询获取一个用户
     *
     * @param userId
     * @return
     */
    public User getById(Long userId) {
        User user = null;
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT * FROM sys_user WHERE id_ = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, userId);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id_"));
                user.setLoginName(resultSet.getString("login_name_"));
                user.setName(resultSet.getString("name_"));
                user.setPassword(resultSet.getString("password_"));
                user.setType(resultSet.getString("type_"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return user;
    }


    public void update(User user){
        Connection connection = DBUtil.getConnection();
        String sql = "update sys_user set name_ = ?,login_name_ = ?,password_ = ? where id_ = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getLoginName());
            ps.setString(3,user.getPassword());
            ps.setLong(4,user.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
