package com.fantasykai.springboot.springbootlearn.repository;

import com.fantasykai.springboot.springbootlearn.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/03 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameOrEmail(String username, String email);

    @Query("select u from User u")
    Page<User> findAll(Pageable pageable);

    Page<User> findByNickname(String nickName, Pageable pageable);

}
