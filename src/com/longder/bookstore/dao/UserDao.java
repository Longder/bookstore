package com.longder.bookstore.dao;

import com.longder.bookstore.entity.User;
import com.longder.bookstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User表的数据库交互对象
 */
public class UserDao {

    /**
     * 根据登录名检查用户
     * @param loginName
     * @return
     */
    public User getByLoginName(String loginName){
        User user = null;
        Connection connection = DBUtil.getConnection();
        String sql = "SELECT * FROM sys_user WHERE login_name_ = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,loginName);
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id_"));
                user.setLoginName(resultSet.getString("login_name_"));
                user.setName(resultSet.getString("name_"));
                user.setPassword(resultSet.getString("password_"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
        return user;
    }

    /**
     * 添加一个用户
     * @param user
     */
    public void add(User user){
        Connection connection = DBUtil.getConnection();
        String sql = "INSERT INTO sys_user(name_, login_name_, password_) values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getLoginName());
            ps.setString(3,user.getPassword());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
    }
}
