package com.fantasykai.springboot.mybatisannotation.web;

import com.fantasykai.springboot.mybatisannotation.entity.UserEntity;
import com.fantasykai.springboot.mybatisannotation.mapper.UserMapper;
import com.fantasykai.springboot.mybatisannotation.param.UserParam;
import com.fantasykai.springboot.mybatisannotation.result.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/users")
    public List<UserEntity> getUsers() {
        List<UserEntity> users = userMapper.getALL();
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
