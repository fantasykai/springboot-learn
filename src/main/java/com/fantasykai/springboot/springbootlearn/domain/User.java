package com.fantasykai.springboot.springbootlearn.domain;

import com.google.common.base.Objects;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/01 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class User {

    private String name;
    private int age;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age &&
                Objects.equal(name, user.name) &&
                Objects.equal(pass, user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age, pass);
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
