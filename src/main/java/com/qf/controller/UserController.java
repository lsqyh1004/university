package com.qf.controller;

import com.qf.pojo.Msg;
import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import com.qf.service.UserService;
import com.qf.utils.UploadUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UploadUtils uploadUtils;
    @Value("${qiniu.url}")
    private String url;
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String MAIL_SENDER;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public int regist(User user) {
        System.out.println(user+"注册");
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
        System.out.println(user+".....................");
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPass());
            subject.login(usernamePasswordToken);
            if (subject.isAuthenticated()) {
                session.setAttribute("user", user);
                return 1;
            }
        } catch (Exception e) {
            return -1;
        }
        return 0;
    }

    @RequestMapping(value = "/findone", method = RequestMethod.GET)
    public User findOne(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return userService.selectByName(user.getName());
        }
        return null;
    }

    //查询所有用户
    @RequestMapping("/infAllUser/{size}/{page}")
    public Msg infAllUser(@PathVariable("size") Integer size, @PathVariable("page") Integer page) {
        return userService.infAllUser(size, page);
    }

    //根据id查询用户
    @RequestMapping(value = "/selectUserById", method = RequestMethod.POST)
    public User selectUserById(@RequestBody User user) {
        User users = userService.selectUserById(user.getId());
        return users;
    }

    //根据id修改用户
    @RequestMapping(value = "/updateUserById", method = RequestMethod.POST)
    public Map<String, Object> updateUserById(@RequestBody User user) {
        System.out.println(user);
        Map<String, Object> map = new HashMap<>();
        try {
            userService.updateUserById(user);
            map.put("jg", 0);
        } catch (Exception e) {
            map.put("jg", 1);
        }
        return map;
    }

    //根据id删除用户
    @RequestMapping(value = "/deleteById", method = RequestMethod.POST)
    public Map<String, Object> deleteById(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.deletezjbById(user.getId());
            userService.deleteById(user.getId());
            map.put("success", "success");
        } catch (Exception e) {
            e.getMessage();
        }
        return map;
    }

    //验证码
    @RequestMapping("/YZM")
    @ResponseBody
    public String YZM(HttpSession session) throws Exception {
        User user = (User)session.getAttribute("user");
        //根据名字获取用户邮箱
        String name = user.getName();
        System.out.println(name+"++++++++++++++++++++++++++++++++++");
        User user1 = userService.selectByName(name);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //发件人
        simpleMailMessage.setFrom(MAIL_SENDER);
        //收件人
        simpleMailMessage.setTo(user1.getEmail());
        //产生随机数
        Integer code=(int)(Math.random() * (1000000));
        //设置主题
        simpleMailMessage.setSubject("验证码");
        //设置内容
        simpleMailMessage.setText("您的验证码是："+code);
        String s= code.toString();
        javaMailSender.send(simpleMailMessage);
        System.out.println(s);
        return s;
    }
}
