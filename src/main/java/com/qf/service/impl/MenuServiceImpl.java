package com.qf.service.impl;

import com.qf.mapper.CollectMapper;
import com.qf.mapper.DiscussMapper;
import com.qf.mapper.MenuMapper;
import com.qf.mapper.MenuRepository;
import com.qf.pojo.*;
import com.qf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private DiscussMapper discussMapper;
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public List<Menu1> selectIndex() {
       return menuMapper.selectIndex();
    }

    @Override
    public List<Menu3> selectM3ByTime() {
        return menuMapper.selectM3ByTime();
    }

    @Override
    public List<Menu2> selectC23ByC1(Integer id) {
        return menuMapper.selectC23ByC1(id);
    }

    @Override
    public Menu4 selectC4ByC3(Integer id) {
        return menuMapper.selectC4ByC3(id);
    }

    @Override
    public Menu3 selectC3ById(Integer id) {
        return menuMapper.selectC3ById(id);
    }

    @Override
    public int editpageview(Integer id) {

        return menuMapper.editpageview(id);
    }

    @Override
    public Sp houtaisp(Integer size,Integer page) {
        if(page<0){
            page=0;
        }else{
            page=page-1;
        }
        Pageable of = PageRequest.of(page, size);
        Page<Menu3> all = menuRepository.findAll(of);
        List<Menu3> content = all.getContent();
        Sp msg=new Sp();
        msg.setList(content);
        msg.setTotals(all.getTotalElements());
        msg.setPages(all.getTotalPages());
        return msg;
    }

    @Override
    public int del(Integer id) {

        System.out.println(menuMapper.delMenu4(id)+"======");
        System.out.println(discussMapper.del(id));
        System.out.println(collectMapper.del(id));
        int s=menuMapper.del(id);
        return s;
    }

    @Override
    public int addM3m4(M3m4 m3m4) {
       menuMapper.addM3(m3m4);
       M3m4 m=menuMapper.select(m3m4);
      return  menuMapper.addM4(m);

    }
}
