package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.pojo.Permission;
import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
    @Override
    public User findOne(User user) {
        return userMapper.findOne(user);
    }

    @Override
    public int add(User user) {

        return userMapper.add(user);
    }

    @Override
    public int addRoler(UserRoler ur) {
        return userMapper.addRoler(ur);
    }

    @Override
    public List<Permission> selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public User selectByName(String name) {
        return userMapper.selectByName(name);
    }

    @Override
    public List<User> infAllUser() {
        return userMapper.infAllUser();
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }


}
