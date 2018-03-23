package com.fantasykai.springboot.mybatisannotation.mapper;

import com.fantasykai.springboot.mybatisannotation.entity.UserEntity;
import com.fantasykai.springboot.mybatisannotation.enums.UserSexEnum;
import com.fantasykai.springboot.mybatisannotation.param.UserParam;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/23 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public interface UserMapper {

    /**
     * Gets all.
     *
     * @return the all
     */
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickname", column = "nickname")
    })
    List<UserEntity> getALL();

    @SelectProvider(type = UserSql.class, method = "getList")
    List<UserEntity> getList(UserParam userParam);

    /**
     * Gets count.
     *
     * @param userParam the user param
     * @return the count
     */
    @SelectProvider(type = UserSql.class, method = "getCount")
    int getCount(UserParam userParam);


    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickname", column = "nickname")
    })
    UserEntity getOne(Long id);

    /**
     * Insert.
     *
     * @param user the user
     */
    @Insert("INSERT INTO users(username,password,user_sex,nickname) VALUES (#{username}, #{password}, #{userSex}, #{nickname})")
    void insert(UserEntity user);

    /**
     * Update.
     *
     * @param user the user
     */
    @Update("UPDATE users SET username = #{username}, nickname = #{nickname} WHERE id = #{id}")
    void update(UserEntity user);

    /**
     * Delete.
     *
     * @param id the id
     */
    @Delete("DELETE FROM users WHERE id = #{id}")
    void delete(Long id);


}
