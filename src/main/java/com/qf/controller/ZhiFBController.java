package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ZhiFBController {
    @RequestMapping("/chongzhi")
    public String chongzhi(){
        return "alipay.trade.page.pay";
    }
    @RequestMapping("/alipay")
    public String alipay(){
        return "alipay.trade.page.pay";
    }
    @RequestMapping("/order")
    public String order(){
        return "order";
    }
}
