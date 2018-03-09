package com.fantasykai.springboot.jpa;

import com.fantasykai.springboot.jpa.entity.User;
import com.fantasykai.springboot.jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/08 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Resource
    private UserRepository userRepository;


    @Test
    public void jpaTest() {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("xiaoming", "xiaoming@163.com", "xiaoming", "a123456", formattedDate));
        userRepository.save(new User("xiaohei", "xiaohei@163.com", "xiaohei", "a123456", formattedDate));
        userRepository.save(new User("xiaoli", "xiaoli@163.com", "xiaoli", "a123456", formattedDate));

        Assert.assertEquals(3, userRepository.findAll().size());

        Assert.assertEquals("xiaohei", userRepository.findByUserNameOrEmail("xiaohei", "xiaohei@163.com").getNickName());

    }

    @Test
    public void testPageQuery() {
        int page = 1, size = 10;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        userRepository.findAll(pageable);
        userRepository.findByNickName("xiaoming", pageable);
    }

    @Test
    public void testCustomSql() {

        userRepository.modifyById("xiaoxiaohei", 1l);

        userRepository.findByEmail("xiaoli@163.com");

    }

}
