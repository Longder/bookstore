package com.longder.bookstore.dao;




import com.longder.bookstore.entity.CartDetail;
import com.longder.bookstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 购物车表的数据库交互对象
 */
public class CartDetailDao {
    /**
     * 向购物车中添加一个商品（包括数量）
     *
     * @param cartDetail
     */
    public void add(CartDetail cartDetail) {
        Connection connection = DBUtil.getConnection();

        try {
            //先检查有这个图书了没？
            String sql = "SELECT * FROM cart_detail where book_id_ = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,cartDetail.getBookId());
            ResultSet resultSet = ps.executeQuery();

            if(resultSet.next()){
                //有 做更新操作
                int oldCount = resultSet.getInt("count_");
                int count = oldCount +cartDetail.getCount();
                double oldPrice = resultSet.getDouble("price_");
                double price = oldPrice + cartDetail.getPrice();
                sql = "update cart_detail set count_ = ?,price_ = ? where book_id_ = ?";
                ps = connection.prepareStatement(sql);
                ps.setInt(1,count);
                ps.setDouble(2,price);
                ps.setLong(3,cartDetail.getBookId());
                ps.execute();
            }else{
                //没有，做插入操作
                sql = "INSERT INTO cart_detail(BOOK_ID_, COUNT_, PRICE_) VALUES (?,?,?)";
                ps = connection.prepareStatement(sql);
                ps.setLong(1, cartDetail.getBookId());
                ps.setInt(2, cartDetail.getCount());
                ps.setDouble(3, cartDetail.getPrice());
                ps.execute();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    /**
     * 查询购物车中的所有内容
     *
     * @return
     */
    public List<CartDetail> listAll() {
        List<CartDetail> detailList = new ArrayList<>();

        Connection connection = DBUtil.getConnection();

        String sql = "select c.*,b.id_ bookId,b.name_ bookName,b.price_ bookPrice from cart_detail c left join book b on c.book_id_ = b.id_";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                CartDetail cartDetail = new CartDetail();
                cartDetail.setId(resultSet.getLong("id_"));
                cartDetail.setBookId(resultSet.getLong("bookId"));
                cartDetail.setBookName(resultSet.getString("bookName"));
                cartDetail.setBookPrice(resultSet.getDouble("bookPrice"));
                cartDetail.setPrice(resultSet.getDouble("price_"));
                cartDetail.setCount(resultSet.getInt("count_"));
                detailList.add(cartDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return detailList;
    }

    /**
     * 从购物车中移除一项
     * @param id
     */
    public void remove(Long id){
        Connection connection = DBUtil.getConnection();

        String sql = "delete from cart_detail where id_ = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1,id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
    }
}
