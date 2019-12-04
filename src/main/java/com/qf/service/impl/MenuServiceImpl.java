package com.qf.service.impl;

import com.qf.mapper.MenuMapper;
import com.qf.pojo.*;
import com.qf.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
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
}
