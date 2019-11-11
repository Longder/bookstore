package com.longder.bookstore.entity;

/**
 * 书本实体
 */
public class Book extends BaseIdEntity {
    /**
     * 书本名称
     */
    private String name;

    /**
     * 书本价格
     */
    private Double price;

    /**
     * 图片的base64值
     */
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
