package com.fantasykai.springboot.jpa;

import com.fantasykai.springboot.jpa.entity.UserDetail;
import com.fantasykai.springboot.jpa.entity.UserInfo;
import com.fantasykai.springboot.jpa.repository.UserDetailRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

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
public class UserInfoRepositoryTests {

    @Resource
    private UserDetailRepository userDetailRepository;

    @Test
    public void testUserDetail() {
        userDetailRepository.save(new UserDetail("1", "中国上海", "篮球"));
        userDetailRepository.save(new UserDetail("2", "中国深圳", "足球"));
        userDetailRepository.save(new UserDetail("3", "中国北京", "乒乓球"));
    }

    @Test
    public void testUserInfo() {

        List<UserInfo> userInfos = userDetailRepository.findUserInfo("篮球");

        for (UserInfo userInfo : userInfos) {
            System.out.println("address : " + userInfo.getAddress());
        }

    }


}
