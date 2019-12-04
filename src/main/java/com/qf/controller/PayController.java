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

    @RequestMapping("/pay")
    public String pay(HttpSession session) {
        String pay="";
        try {
            pay = alipayUtils.pay();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        User user = (User) session.getAttribute("user");
        if (user!=null){
            User user1 = userService.selectByName(user.getName());

                userService.updateUserRoler(user1.getId());


        }
        return pay;
    }

}