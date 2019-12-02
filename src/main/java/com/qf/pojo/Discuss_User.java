package com.qf.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Discuss_User {
    private List<Discuss> list;
    private Menu4 menu4;
    private Integer rows;
}
