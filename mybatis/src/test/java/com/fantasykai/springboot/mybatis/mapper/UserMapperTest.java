package com.fantasykai.springboot.mybatis.mapper;

import com.fantasykai.springboot.mybatis.entity.UserEntity;
import com.fantasykai.springboot.mybatis.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/21 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testInsert() {

        userMapper.insert(new UserEntity("xiaohei", "a123456", "小黑", UserSexEnum.MAN));
        userMapper.insert(new UserEntity("xiaohong", "a123456", "小红", UserSexEnum.WOMAN));
        userMapper.insert(new UserEntity("xiaoli", "a123456", "小莉", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testQuery() {
        List<UserEntity> users = userMapper.getAll();
        if (CollectionUtils.isEmpty(users)) {
            System.out.println("is null");
        } else {
            System.out.println(users.toString());
        }
    }

    @Test
    public void testUpdate() {
        long id = 3l;
        UserEntity user = userMapper.getOne(id);

        if (null != user) {
            System.out.println(user.toString());
            user.setNickname("小兰");
            userMapper.update(user);
            Assert.assertTrue("小兰".equals(userMapper.getOne(id).getNickname()));
        } else {
            System.out.println("not find user  id is: " + id);
        }


    }

}
