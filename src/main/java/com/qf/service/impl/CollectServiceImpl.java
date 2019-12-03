package com.qf.service.impl;

import com.qf.mapper.CollectMapper;
import com.qf.pojo.Collect;
import com.qf.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public Collect selectByUidAndM3Id(Integer uid, Integer id) {
        return collectMapper.selectByUidAndM3Id(uid,id);

    }

    @Override
    public int add(Collect collect) {
        return collectMapper.add(collect);
    }

    @Override
    public List<Collect> findall(Integer uid, Integer sid) {
        return collectMapper.findall(uid,sid);
    }
}
