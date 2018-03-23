package com.fantasykai.springboot.mybatis.mapper;

import com.fantasykai.springboot.mybatis.entity.UserEntity;
import com.fantasykai.springboot.mybatis.param.UserParam;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/19 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public interface UserMapper {

    List<UserEntity> getAll();

    List<UserEntity> getList(UserParam userParam);

    int getCount(UserParam userParam);

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    int update(UserEntity user);

    int delete(Long id);
}
