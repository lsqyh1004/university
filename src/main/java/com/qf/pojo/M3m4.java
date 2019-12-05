package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class M3m4 {
    private Integer id3;
    private String name3;
    private String school;
    private Integer pageview;
    private Integer m2_id;
    private String pic;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private String prief;
    private String target;
    private String url;
}
