package com.fantasykai.springboot.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/09 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Entity
public class UserDetail implements Serializable {

    private static final long serialVersionUID = -2124618408676792613L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String hobby;

    /**
     * 使用枚举
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private UserSexEnum sex;

    @Transient
    private String detail;


    /**
     * Instantiates a new User detail.
     */
    public UserDetail() {

    }

    /**
     * Instantiates a new User detail.
     *
     * @param userId  the user id
     * @param address the address
     * @param hobby   the hobby
     */
    public UserDetail(String userId, String address, String hobby, UserSexEnum sex, String detail) {
        this.userId = userId;
        this.address = address;
        this.hobby = hobby;
        this.sex = sex;
        this.detail = detail;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }


    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets hobby.
     *
     * @return the hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * Sets hobby.
     *
     * @param hobby the hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }

}

