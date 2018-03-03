package com.fantasykai.springboot.springbootlearn.repository;

import com.fantasykai.springboot.springbootlearn.entity.UserDetail;
import com.fantasykai.springboot.springbootlearn.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/03 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    UserDetail findByHobby(String hobby);

    //特别注意这里的 SQL 是 HQL，需要写类的名和属性，这块很容易出错。
    @Query("select u.username as username, u.email as email, d.address as address, d.hobby as hobby from User u, UserDtail d where u.id = d.userId and d.hobby = ?1")
    List<UserInfo> findUserInfo(String hobby);
}
