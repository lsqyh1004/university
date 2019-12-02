package com.qf.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Menu2 {
    private Integer id;
    private String name2;
    private Integer m1_id;
    private List<Menu3> list;
}
