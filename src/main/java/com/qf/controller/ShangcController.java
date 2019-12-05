package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ShangcController {
    @RequestMapping("/shangc")
    @ResponseBody
    public String shangc(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            return "上传失败";
        }
        String fileName=file.getOriginalFilename();
        String filepath="F:/img/";
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        File dest=new File(filepath+uuid+fileName);
        String s="http://10.12.159.125:1018/"+uuid+fileName;
        try {
            file.transferTo(dest);
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
