package com.fantasykai.springboot.springbootlearn;

import com.fantasykai.springboot.springbootlearn.entity.User;
import com.fantasykai.springboot.springbootlearn.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/03 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Resource
    private UserRepository userRepository;

    @Test
    public void test() {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("xiaoming", "xiaoming@163.com", "xiaoming", "a123456", formattedDate));
        userRepository.save(new User("xiaohei", "xiaohei@163.com", "xiaohei", "a123456", formattedDate));
        userRepository.save(new User("xiaoli", "xiaoli@163.com", "xiaoli", "a123456", formattedDate));

        Assert.assertEquals(3, userRepository.findAll().size());
        Assert.assertEquals("xiaohei", userRepository.findByUsernameOrEmail("xiaohei", "xiaohei@163.com").getNickname());
//        userRepository.delete(userRepository.findByUsername("xiaomiao"));
    }

    @Test
    public void testBaseQuery() {

        userRepository.findAll();
        userRepository.findOne(20L);
        userRepository.count();
        userRepository.exists(1L);
    }


}
