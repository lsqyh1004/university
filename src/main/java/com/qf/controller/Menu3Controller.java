package com.qf.controller;

import com.qf.pojo.Menu3;
import com.qf.service.Menu3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class Menu3Controller {
    @Autowired
    private Menu3Service menu3Service;
    @ResponseBody
    @RequestMapping("/selectMenu3mohuByName")
    public List selectMenu3mohuByName(@RequestParam("name") String name){
        if (name!=null){
            name="%"+name+"%";
        }
        System.out.println(name+"........................");
        List<Menu3> menu3s = menu3Service.selectMenu3mohuByName(name);
        return menu3s;
    }
}
