package com.fantasykai.springboot.jpathymeleaf.param;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import sun.awt.SunHints;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/12 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class UserParam {

    private long id;

    @NotEmpty(message = "{user.name.notEmpty}")
    private String userName;

    @Max(value = 1, message = "{user.sex.value}")
    @Min(value = 0, message = "{user.sex.value}")
    private int age;

    @NotEmpty(message = "{user.passwd.notEmpty}")
    @Length(min = 6, message = "{user.passwd.length}")
    private String passwd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
