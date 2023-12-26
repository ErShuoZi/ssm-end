package com.controller;

import com.bean.Furn;
import com.bean.Msg;
import com.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@CrossOrigin(origins = "http://127.0.0.1:5173")
@Controller
@ResponseBody
public class FurnController {
//    注入Service
    @Resource
    private FurnService furnService;
    //相应客户端添加请求
    @RequestMapping("/save")
    public Msg save(@RequestBody Furn furn){
        furnService.save(furn);
        //返回成功信息
        Msg success = Msg.success();
        return success;
    }
}
