package com.service.impl;

import com.bean.Furn;
import com.bean.FurnExample;
import com.dao.FurnMapper;
import com.service.FurnService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FurnServiceImpl implements FurnService {

//    注入FurnMapper接口对象(代理对象)
    @Resource
    private FurnMapper furnMapper;
    @Override
    public void save(Furn furn) {

        furnMapper.insertSelective(furn);
    }

    @Override
    public List<Furn> findAll() {
        return  furnMapper.selectByExample(null);
    }

    @Override
    public void update(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public void delete(Integer id) {
        furnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Furn> findByCondition(String name) {
        FurnExample furnExample = new FurnExample();
//        通过criteria可以设置查询条件
        FurnExample.Criteria criteria = furnExample.createCriteria();
//        判断name是否有效
        if (StringUtils.hasText(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        //如果name无效，则依然是查询所有
        return furnMapper.selectByExample(furnExample);
    }
}
