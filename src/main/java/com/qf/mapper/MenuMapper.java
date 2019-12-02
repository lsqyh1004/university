package com.qf.mapper;

import com.qf.pojo.Menu1;
import com.qf.pojo.Menu2;
import com.qf.pojo.Menu3;
import com.qf.pojo.Menu4;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<Menu1> selectIndex();//查询首页展示的一级三级菜单

    List<Menu3> selectM3ByTime();//首页展示最新上架的三级菜单

    List<Menu2> selectC23ByC1(Integer id);//点击一级菜单查询二三级菜单

    Menu4 selectC4ByC3(Integer id);
}
