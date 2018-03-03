package com.fantasykai.springboot.springbootlearn.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 多表查询
 * 多表查询在 Spring Data JPA 中有两种实现方式，第一种是利用 hibernate 的级联查询来实现，
 * 第二种是创建一个结果集的接口来接收连表查询后的结果，这里主要使用第二种方式。
 * <p>
 *
 * @author Created by makai on 2018/03/03 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public class UserDetail implements Serializable {

    private static final long serialVersionUID = -6075739780022063207L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = true)
    private String address;

    @Column(nullable = true)
    private String hobbyp;


    @Override
    public String toString() {
        return com.alibaba.fastjson.JSON.toJSONString(this);
    }

}
