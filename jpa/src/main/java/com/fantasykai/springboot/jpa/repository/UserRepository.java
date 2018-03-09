package com.fantasykai.springboot.jpa.repository;

import com.fantasykai.springboot.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/08 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 自定义简单查询
     * 自定义的简单查询就是根据方法名来自动生成 SQL，主要的语法是 findXXBy、readAXXBy、queryXXBy、countXXBy、getXXBy 后面跟属性名称：
     */

    User findByUserName(String userName);

    //也可以加一些关键字 And、Or：
    User findByUserNameOrEmail(String userName, String email);

    /**
     * //    // 修改删除，统计等语法
     * <p>
     * Long deleteById(Long id);
     * <p>
     * Long countByUserName(String userName);
     * <p>
     * // SQL 体系中的关键词都可以使用，如 LIKE、IgnoreCase、OrderBy。、
     * <p>
     * List<User> findByEmailLike(String email);
     * <p>
     * User findbyUserNameIgnoreCase(String userName);
     * <p>
     * List<User> findByUserNameOrderByEmailDesc(String email);
     */

    // 支持分页查询
    @Query("select  u from  User u")
    Page<User> findAll(Pageable pageable);

    Page<User> findByNickName(String nickName, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update User  set userName = ?1 where id = ?2")
    int modifyById(String userName, Long id);

    @Transactional
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteById(Long id);

    @Query("select u from  User u where u.email = ?1")
    User findByEmail(String email);

}
