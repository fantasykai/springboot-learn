package com.fantasykai.springboot.jpathymeleaf.repository;

import com.fantasykai.springboot.jpathymeleaf.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author makai on 2018/03/12 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select  u from User u")
    Page<User> findList(Pageable pageable);

    User findById(long id);

    User findByUserName(String userName);

    Long deleteBy(Long id);

}
