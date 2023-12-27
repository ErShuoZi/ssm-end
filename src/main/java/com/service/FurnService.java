package com.service;

import com.bean.Furn;

import java.util.List;

public interface FurnService {
    //添加
    public void save(Furn furn);
    //查询所有
    public List<Furn> findAll();
    //更新
    public void update(Furn furn);

    //删除
    public void delete(Integer id);

    //根据条件查询
    public List<Furn> findByCondition(String name);
}
