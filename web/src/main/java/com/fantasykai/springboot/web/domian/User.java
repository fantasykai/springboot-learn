package com.fantasykai.springboot.web.domian;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/07 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class User {

    @NotEmpty(message = "{user.name.notEmpty}")
    private String name;


    @Max(value = 150, message = "{user.age.max}")
    @Min(value = 1, message = "{user.age.min")
    private int sex;


    @Max(value = 1, message = "{user.sex.value}")
    @Min(value = 0, message = "{user.sex.value}")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return sex == user.sex &&
                age == user.age &&
                Objects.equal(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, sex, age);
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
