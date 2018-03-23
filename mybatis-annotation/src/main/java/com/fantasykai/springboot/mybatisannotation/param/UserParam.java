package com.fantasykai.springboot.mybatisannotation.param;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/19 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class UserParam extends PageParam {

    private String username;

    private String userSex;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }

}
