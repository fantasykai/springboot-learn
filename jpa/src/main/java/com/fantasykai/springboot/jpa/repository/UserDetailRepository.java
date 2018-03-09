package com.fantasykai.springboot.jpa.repository;

import com.fantasykai.springboot.jpa.entity.UserDetail;
import com.fantasykai.springboot.jpa.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author makai on 2018/03/09 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {

    UserDetail findByHobby(String hobby);

    @Query("select u.userName as userName, u.email as email, d.address as address , d.hobby as hobby from User u , UserDetail d " +
            "where u.id=d.userId  and  d.hobby = ?1 ")
    List<UserInfo> findUserInfo(String hobby);


}
