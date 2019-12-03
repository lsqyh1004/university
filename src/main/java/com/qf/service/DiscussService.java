package com.qf.service;

import com.qf.pojo.Discuss;

import java.util.List;

public interface DiscussService {
    List<Discuss> selectById(Integer id);

    int getRows(Integer id);

    int add(Discuss discuss);
}
