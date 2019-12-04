package com.qf.mapper;

import com.qf.pojo.Collect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectMapper {
    Collect selectByUidAndM3Id(Integer uid, Integer id);

    int add(Collect collect);

    List<Collect> findall(Integer uid, Integer sid);

    int del(Integer id);
}
