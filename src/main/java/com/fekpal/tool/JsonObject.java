package com.fekpal.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by APone on 2017/8/14.
 * 用于序列化传输的json类，不提供list的setter方法
 */
@Deprecated
public class JsonObject {

    private int status;

    private String msg;

    private List<Map<String,Object>> data=new ArrayList<Map<String, Object>>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }
}
