package com.qf.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Msg {
    private List<User> list;
    private Integer page;

    private long total;
}
