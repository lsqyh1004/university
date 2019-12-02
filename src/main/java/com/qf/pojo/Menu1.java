package com.qf.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Menu1 {
    private Integer id;
    private String name;
    private Theme t;
    private List<Menu3> list;
}
