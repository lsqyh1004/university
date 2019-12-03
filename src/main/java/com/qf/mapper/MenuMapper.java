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

    Menu4 selectC4ByC3(Integer id);//通过三级菜单的编号展示四级菜单的相关数据

    Menu3 selectC3ById(int id);//通过三级菜单得编号查询三级菜单的一条数据

    int editpageview(Integer id);//修改浏览量
}
