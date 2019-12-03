package com.qf.mapper;

import com.qf.pojo.Menu3;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Menu3Mapper {
    //根据名称模糊查询
    List<Menu3> selectMenu3mohuByName(String name);
}
