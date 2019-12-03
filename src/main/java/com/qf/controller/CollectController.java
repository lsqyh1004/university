package com.qf.controller;

import com.qf.pojo.Collect;
import com.qf.pojo.Menu3;
import com.qf.pojo.User;
import com.qf.service.CollectService;
import com.qf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @Autowired
    private MenuService menuService;
    @RequestMapping("/add/{id}/{sid}")
    public int add(@PathVariable("id") Integer id, @PathVariable("sid") Integer sid, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user==null){
            return -1;
        }else{
            Menu3 menu3 = menuService.selectC3ById(id);
            Collect collect=new Collect();
            collect.setName(menu3.getName3());
            collect.setM3_id(id);
            collect.setSid(2);
            collect.setUid(user.getId());
            collect.setUrl(menu3.getPic());
           return collectService.add(collect);
        }
    }
    @RequestMapping("/findall/{sid}")
    public List<Collect> findall(@PathVariable("sid") Integer sid,HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user!=null){
            return collectService.findall(user.getId(),sid);
        }
        return null;
    }

}
