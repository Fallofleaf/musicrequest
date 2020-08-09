package com.flywinter.musicrequest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by IntelliJ IDEA
 * User:Xingkun Zhang
 * Date:2020/8/8
 * Description:
 */
@Controller
public class Music {
    @GetMapping("/")
    public String getHtml(){
        return "audioNew";
    }
    @GetMapping("/audio")
    public String get(){
        return "audio";
    }
}
