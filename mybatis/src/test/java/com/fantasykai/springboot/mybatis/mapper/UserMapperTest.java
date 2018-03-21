package com.fantasykai.springboot.mybatis.mapper;

import com.fantasykai.springboot.mybatis.entity.UserEntity;
import com.fantasykai.springboot.mybatis.enums.UserSexEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

}
