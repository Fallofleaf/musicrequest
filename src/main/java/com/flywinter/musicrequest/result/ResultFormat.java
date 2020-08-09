package com.flywinter.musicrequest.result;

/**
 * Created by IntelliJ IDEA
 * User:Xingkun Zhang
 * Date:2020/8/7
 * Description:
 */
public class ResultFormat{
    private int code;
    private String name;
    private String url;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ResultFormat(int code, String name, String url) {
        this.code = code;
        this.name = name;
        this.url = url;
    }

    public ResultFormat() {
    }
}
