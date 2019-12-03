package com.qf.service.impl;

import com.qf.mapper.Menu3Mapper;
import com.qf.pojo.Menu3;
import com.qf.service.Menu3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Menu3ServiceImpl implements Menu3Service {
    @Autowired
    private Menu3Mapper menu3Mapper;
    @Override
    public List<Menu3> selectMenu3mohuByName(String name) {
        return menu3Mapper.selectMenu3mohuByName(name);
    }
}
