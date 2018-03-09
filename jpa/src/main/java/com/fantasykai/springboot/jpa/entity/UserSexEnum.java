package com.fantasykai.springboot.jpa.entity;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/09 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public enum UserSexEnum {
    /**
     * Man user sex enum.
     */
    MAN("1"),
    /**
     * Woman user sex enum.
     */
    WOMAN("0");

    /**
     * The Value.
     */
    public final String value;

    UserSexEnum(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
