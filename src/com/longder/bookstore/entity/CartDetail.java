package com.longder.bookstore.entity;

/**
 * 购物车中一个详情的实体
 */
public class CartDetail extends BaseIdEntity{

    /**
     * 书本id
     */
    private Long bookId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 数量
     */
    private Integer count;

    /**
     * 单条详情的价格
     */
    private Double price;

    /**
     * 图书名称
     */
    private String bookName;
    /**
     * 书本单价
     */
    private Double bookPrice;


    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
