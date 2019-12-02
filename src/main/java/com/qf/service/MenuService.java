package com.qf.service;

import com.qf.pojo.Menu1;
import com.qf.pojo.Menu2;
import com.qf.pojo.Menu3;
import com.qf.pojo.Menu4;

import java.util.List;

public interface MenuService {
    List<Menu1> selectIndex();

    List<Menu3> selectM3ByTime();

    List<Menu2> selectC23ByC1(Integer id);

    Menu4 selectC4ByC3(Integer id);
}
