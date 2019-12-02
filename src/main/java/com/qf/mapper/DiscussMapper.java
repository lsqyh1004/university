package com.qf.mapper;

import com.qf.pojo.Discuss;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DiscussMapper {
    List<Discuss> selectById(Integer id);

    int getRows(int id);
}
