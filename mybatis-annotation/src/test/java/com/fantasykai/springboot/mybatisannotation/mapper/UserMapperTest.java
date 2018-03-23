package com.fantasykai.springboot.mybatisannotation.mapper;

import com.fantasykai.springboot.mybatisannotation.entity.UserEntity;
import com.fantasykai.springboot.mybatisannotation.enums.UserSexEnum;
import com.fantasykai.springboot.mybatisannotation.param.UserParam;
import com.fantasykai.springboot.mybatisannotation.result.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/23 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {

        userMapper.insert(new UserEntity("xiaoyi", "a123456", "小一", UserSexEnum.MAN));
        userMapper.insert(new UserEntity("xiaolong", "a123456", "小龙", UserSexEnum.WOMAN));
        userMapper.insert(new UserEntity("xiaotian", "a123456", "小天", UserSexEnum.WOMAN));

        Assert.assertEquals(6, userMapper.getALL().size());
    }

    @Test
    public void testQuery() {
        List<UserEntity> users = userMapper.getALL();
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
            user.setNickname("小雨");
            userMapper.update(user);
            Assert.assertTrue("小雨".equals(userMapper.getOne(id).getNickname()));
        } else {
            System.out.println("not find user  id is: " + id);
        }
    }


    @Test
    public void testPage() {
        UserParam userParam = new UserParam();
        userParam.setUserSex("MAN");
        userParam.setCurrentPage(1);
        List<UserEntity> users = userMapper.getList(userParam);
        long count = userMapper.getCount(userParam);
        Page page = new Page(userParam, count, users);
        System.out.println(page);
    }


}
