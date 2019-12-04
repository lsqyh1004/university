package com.qf.controller;

import com.alipay.api.AlipayApiException;
import com.qf.pojo.User;
import com.qf.pojo.UserRoler;
import com.qf.service.UserService;
import com.qf.utils.AlipayUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class PayController {

    @Autowired
    private AlipayUtils alipayUtils;
    @Autowired
    private UserService userService;


    public String pay(Integer uid) {
        String pay="";
        try {
            pay = alipayUtils.pay();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        int m=userService.updateUserRoler(uid);
        return pay;
    }
    @RequestMapping("/pay")
    public int pay1(HttpSession session){
        User user = (User) session.getAttribute("user");
        int uid=0;
        if (user==null){
            return -1;
        }else{
            User user1 = userService.selectByName(user.getName());
            uid=user1.getId();
           UserRoler ur= userService.selectRoler(user1.getId());
           if (ur.getRid()==2){
               return 0;
           }
           this.pay(uid);
            return 3;
        }
    }

}