package com.qf.service;

import com.qf.pojo.Menu3;

import java.util.List;

public interface Menu3Service {
    //根据名称模糊查询
    List<Menu3> selectMenu3mohuByName(String name);

    List<Menu3> selctLikeNull();
}
