package com.longder.bookstore.entity;

import java.io.Serializable;

/**
 * 所有实体的父类，包括了id（主键）
 */
public class BaseIdEntity implements Serializable {
    /**
     * id值，主键
     */
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
