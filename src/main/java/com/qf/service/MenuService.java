package com.qf.service;

import com.qf.pojo.*;

import java.util.List;

public interface MenuService {
    List<Menu1> selectIndex();

    List<Menu3> selectM3ByTime();

    List<Menu2> selectC23ByC1(Integer id);

    Menu4 selectC4ByC3(Integer id);

    Menu3 selectC3ById(Integer id);

    int editpageview(Integer id);

    Sp houtaisp(Integer size,Integer page);

    int del(Integer id);

    int addM3m4(M3m4 m3m4);
}
