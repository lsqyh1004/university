package com.qf.pojo;

import lombok.Data;

import java.util.List;
@Data
public class Sp {
    private Integer pages;
    private List<Menu3> list;
    private long totals;
}
