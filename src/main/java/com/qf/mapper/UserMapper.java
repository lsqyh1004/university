package com.qf.mapper;

import com.qf.pojo.Permission;
import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User findOne(User user);

    int add(User user);

    int addRoler(UserRoler ur);

    List<Permission> selectById(Integer id);

    User selectByName(String name);

}
