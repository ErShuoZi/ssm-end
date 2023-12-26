package com.service.impl;

import com.bean.Furn;
import com.dao.FurnMapper;
import com.service.FurnService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FurnServiceImpl implements FurnService {

//    注入FurnMapper接口对象(代理对象)
    @Resource
    private FurnMapper furnMapper;
    @Override
    public void save(Furn furn) {
        System.out.println("1111");
        furnMapper.insertSelective(furn);
    }
}
