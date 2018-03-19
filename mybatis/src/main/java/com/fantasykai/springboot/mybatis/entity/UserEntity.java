package com.fantasykai.springboot.mybatis.entity;

import com.fantasykai.springboot.mybatis.enums.UserSexEnum;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/19 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -4064024808301050742L;

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private UserSexEnum userSex;

    public UserEntity() {
        super();
    }

    public UserEntity(String username, String password, String nickname, UserSexEnum userSex) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.userSex = userSex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
