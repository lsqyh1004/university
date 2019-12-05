package com.qf.controller;

import com.qf.pojo.*;
import com.qf.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
    @Autowired
    private ThemeService themeService;
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
    //后台查询视频相关数据
    @RequestMapping("/houtaisp/{size}/{page}")
    public Sp houtaisp(@PathVariable("size") Integer size, @PathVariable("page") Integer page){

       return menuService.houtaisp(size,page);
    }
    @RequestMapping(value = "/del",method = RequestMethod.POST)
    public int del(@RequestBody Menu3 menu3){

        return menuService.del(menu3.getId3());
    }
    //后台新增
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public int addM34(@RequestBody M3m4 m3m4){
        System.out.println(m3m4+"===========");
        m3m4.setTime(new Date());
        return menuService.addM3m4(m3m4);
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public int edit(@RequestBody Menu3 menu3){
        System.out.println(menu3+"+++++++++++");
        return menuService.edit(menu3);
    }
    @RequestMapping(value = "/findOne",method = RequestMethod.POST)
    public Menu3 findOne(@RequestBody M3m4 menu3){
        if (menu3!=null){
            return menuService.selectC3ById(menu3.getId3());
        }
        return null;
    }
}
