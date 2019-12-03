package com.qf.service;

import com.qf.pojo.Permission;
import com.qf.pojo.User;
import com.qf.pojo.UserRoler;

import java.util.List;

public interface UserService {
    User findOne(User user);

    int add(User user);

    int addRoler(UserRoler ur);

    List<Permission> selectById(Integer id);

    User selectByName(String name);

}
