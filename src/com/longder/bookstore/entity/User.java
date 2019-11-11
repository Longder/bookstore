package com.longder.bookstore.entity;

/**
 * 用户表
 */
public class User extends BaseIdEntity {

    /**
     * 姓名
     */
    private String name;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 登陆 密码
     */
    private String password;

    /**
     * 用户类型
     */
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
