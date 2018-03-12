package com.fantasykai.springboot.thymeleaf.domain;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/12 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class User {

    private String userName;

    private int sex;

    private int age;

    public User() {

    }

    public User(String userName, int sex, int age) {
        this.userName = userName;
        this.sex = sex;
        this.age = age;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
