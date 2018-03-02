package com.fantasykai.springboot.springbootlearn.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/02 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@Component
public class ConsProperties {

    @Value("${name_not_null}")
    private String name_not_null;

    public String getName_not_null() {
        return name_not_null;
    }

    public void setName_not_null(String name_not_null) {
        this.name_not_null = name_not_null;
    }

    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }
}