package com.qf.controller;

import com.qf.pojo.*;
import com.qf.service.CollectService;
import com.qf.service.DiscussService;
import com.qf.service.MenuService;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private DiscussService discussService;
    @Autowired
    private UserService userService;
    @Autowired
    private CollectService collectService;
    @RequestMapping("/index")
    public Index index() {
        List<Menu3> menu3s = menuService.selectM3ByTime();
        List<Menu1> menu1s = menuService.selectIndex();
        Index index = new Index();
        index.setList1(menu1s);
        index.setList2(menu3s);
        return index;
    }
    @RequestMapping("/selectC23ByC1/{id}")
    public List<Menu2> selectC23ByC1(@PathVariable("id") Integer id){
        return menuService.selectC23ByC1(id);
    }
    @RequestMapping("/selectC4ByC3/{id}")
    public Discuss_User selectC4ByC3(@PathVariable("id") Integer id, HttpSession session){
        //修改浏览量、历史记录
        User user =(User)session.getAttribute("user");

        if (user!=null){
            User user1 = userService.selectByName(user.getName());
            int uid=user1.getId();
            Menu3 menu3=menuService.selectC3ById(id);
            if (collectService.selectByUidAndM3Id(uid,id)==null){
                Collect collect=new Collect();
                collect.setName(menu3.getName3());
                collect.setM3_id(id);
                collect.setSid(1);
                collect.setUid(uid);
                collect.setUrl(menu3.getPic());
                collectService.add(collect);
            }
        }
        menuService.editpageview(id);
        Menu4 menu4 = menuService.selectC4ByC3(id);
        List<Discuss> discusses = discussService.selectById(id);
        int num=discussService.getRows(id);
        Discuss_User du=new Discuss_User();
        du.setList(discusses);
        du.setMenu4(menu4);
        du.setRows(num);
        return du;
    }
}
