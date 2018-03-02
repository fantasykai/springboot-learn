package com.fantasykai.springboot.springbootlearn.domain;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

    @NotEmpty(message = "{user.name.notEmpty}")
    private String name;

    @Max(value = 150, message = "年龄不能大于 150 岁")
    @Min(value = 1, message = "年龄不能小于 1 岁")
    private int age;

    @Max(value = 1, message = "性别只能是0或1")
    @Min(value = 0, message = "性别只能是0或1")
    private int sex;

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


    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
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
                Objects.equal(sex, user.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, age, sex);
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}
