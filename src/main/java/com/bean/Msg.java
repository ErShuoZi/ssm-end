package com.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Msg 后端服务返回给前端的json数据的对象，本质就是数据规则
 */
public class Msg {
    private int code;     //状态码 200：success ，400:error
    private String message;   //说明
    private Map<String,Object> extend = new HashMap<>(); //返回给客户端/浏览器的数据-Map集合

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }

//返回成功对应的msg
    public static Msg success() {
        Msg msg = new Msg();
        msg.setCode(200);
        msg.setMessage("success");
        return msg;
    }

    //返回失败对应的msg
    public static Msg fail() {
        Msg msg = new Msg();
        msg.setCode(400);
        msg.setMessage("fail");
        return msg;
    }

    //给返回的msg设置数据
    public Msg add(String key,Object value) {
        extend.put(key,value);
        return this;
    }
}
