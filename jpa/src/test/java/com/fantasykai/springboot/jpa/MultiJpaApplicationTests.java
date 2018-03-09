package com.fantasykai.springboot.jpa;

import com.fantasykai.springboot.jpa.entity.User;
import com.fantasykai.springboot.jpa.repository.datasource1.UserDS1Repository;
import com.fantasykai.springboot.jpa.repository.datasource2.UserDS2Repository;
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
 * @author Created by makai on 2018/03/09 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiJpaApplicationTests {

    @Resource
    private UserDS1Repository userDS1Repository;

    @Resource
    private UserDS2Repository userDS2Repository;


    /**
     * Test save data.
     *
     * @throws Exception the exception
     */
    @Test
    public void testSaveData() throws Exception {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userDS1Repository.save(new User("xiaohei", "xiaohei@126.com", "xiaohei", "a123456", formattedDate));
        userDS1Repository.save(new User("xiaolan", "xiaolan@126.com", "xiaolan", "a123456", formattedDate));
        userDS2Repository.save(new User("xiaoyu", "xiaoyu@126.com", "xiaoyu", "a123456", formattedDate));
    }


    /**
     * Test base query.
     */
    public void testBaseQuery() {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        User user = new User("xiaojie", "xiaojie@lieren.com", "xiaojie", "a123456", formattedDate);

        userDS1Repository.findAll();
        userDS2Repository.findOne(1L);
        userDS2Repository.save(user);
        user.setId(2L);

        userDS1Repository.delete(user);
        userDS1Repository.count();
        userDS2Repository.exists(2L);

    }


}
