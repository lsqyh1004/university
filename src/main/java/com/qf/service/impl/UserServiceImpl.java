package com.qf.service.impl;

import com.qf.mapper.UserMapper;
import com.qf.mapper.UserRepository;
import com.qf.pojo.Msg;
import com.qf.pojo.Permission;
import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
@Autowired
private UserRepository userRepository;
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
    public Msg infAllUser(Integer size,Integer page) {
        if(page<0){
            page=0;
        }else{
            page=page-1;
        }
        Pageable of = PageRequest.of(page, size);
        Page<User> all = userRepository.findAll(of);
        List<User> content = all.getContent();
        Msg msg = new Msg();
        msg.setList(content);
        msg.setTotal(all.getTotalElements());
        msg.setPage(all.getTotalPages());
        return msg;
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    @Override
    public void deletezjbById(int id) {
        userMapper.deletezjbById(id);
    }
}
