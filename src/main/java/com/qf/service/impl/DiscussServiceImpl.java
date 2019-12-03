package com.qf.service.impl;

import com.qf.mapper.DiscussMapper;
import com.qf.pojo.Discuss;
import com.qf.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired
    private DiscussMapper discussMapper;
    @Override
    public List<Discuss> selectById(Integer id) {
        return discussMapper.selectById(id);
    }

    @Override
    public int getRows(Integer id) {
        return discussMapper.getRows(id);
    }

    @Override
    public int add(Discuss discuss) {
        return discussMapper.add(discuss);
    }
}
