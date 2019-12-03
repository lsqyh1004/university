package com.qf.controller;

import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import com.qf.service.UserService;
import com.qf.utils.UploadUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UploadUtils uploadUtils;
    @Value("${qiniu.url}")
    private String url;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public int regist(User user) {
        if (userService.findOne(user) != null) {
            return -1;
        } else {
            userService.add(user);
            Integer id = userService.findOne(user).getId();
            UserRoler ur = new UserRoler();
            ur.setUid(id);
            ur.setRid(1);
            return userService.addRoler(ur);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int login(User user, HttpSession session) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPass());
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()) {
                session.setAttribute("user",user);
                return 1;
            }
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }
    @RequestMapping(value = "/findone",method = RequestMethod.GET)
    public User findOne(HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            return userService.selectByName(user.getName());
        }
        return null;
    }
}
