package com.fantasykai.springboot.mybatis.web;

import com.fantasykai.springboot.mybatis.entity.UserEntity;
import com.fantasykai.springboot.mybatis.mapper.UserMapper;
import com.fantasykai.springboot.mybatis.param.UserParam;
import com.fantasykai.springboot.mybatis.result.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 *
 * @author Created by makai on 2018/03/19 .
 * @see [相关类/方法]（可选）
 * @since [产品 /模块版本] （可选）
 */
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserEntity> getUsers() {
        List<UserEntity> users = userMapper.getAll();
        return users;
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public Page<UserEntity> getList(UserParam userParam) {
        List<UserEntity> users = userMapper.getList(userParam);
        long count = userMapper.getCount(userParam);
        Page page = new Page(userParam, count, users);

        return page;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserEntity getUser(Long id) {
        UserEntity user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void save(UserEntity user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void update(UserEntity user) {
        userMapper.update(user);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }


}
