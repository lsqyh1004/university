package com.qf.controller;

import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import com.qf.service.UserService;
import com.qf.utils.UploadUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UploadUtils uploadUtils;
    @Value("${qiniu.url}")
    private  String url;
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public int regist(User user){
        if (userService.findOne(user)!=null){
            return -1;
        }else{
            userService.add(user);
            Integer id = userService.findOne(user).getId();
            UserRoler ur=new UserRoler();
            ur.setUid(id);
            ur.setRid(1);
           return userService.addRoler(ur);
        }
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public int login(User user){
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPass());
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()){
                return 1;
            }
        }catch (Exception e){
            return -1;
        }
        return 0;
    }
    //查询所有用户
    @RequestMapping("/infAllUser")
    public Map<String,Object> infAllUser(){
        List<User> users = userService.infAllUser();
        Map<String,Object> map=new HashMap<>();
        map.put("users",users);
        return map;
    }
    //根据id查询用户
    @RequestMapping(value = "/updateUserById",method = RequestMethod.POST)
    public Map<String,Object> selectUserById(@RequestParam("id") int id){
        Map<String,Object> map=new HashMap<>();
            User user = userService.selectUserById(id);
            map.put("user",user);
            return map;
    }
    //根据id修改用户
    @RequestMapping(value = "/updateUserById",method = RequestMethod.GET)
    public Map<String,Object> updateUserById(User user){
        Map<String,Object> map=new HashMap<>();
        try {
            userService.updateUserById(user);
            map.put("jg",0);
        }catch (Exception e){
            map.put("jg",1);
        }
        return map;
    }

}
