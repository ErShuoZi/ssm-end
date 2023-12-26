package com;

import com.bean.Furn;
import com.dao.FurnMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

public class FurnMapperTest {
    @Test
    public void insertSelective() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = new Furn(null, "北欧风格沙发~", "顺平家居~", new BigDecimal(180), 666, 7, "assets/images/product-image/1.jpg");
        int affected = furnMapper.insertSelective(furn);
        System.out.println("affected--" + affected );
        System.out.println("success~");
    }


    @Test
    public void deleteByPrimaryKey() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        int affected = furnMapper.deleteByPrimaryKey(5);
        System.out.println("affected" + affected);
        System.out.println("删除成功");
    }

    @Test
    public void updateByPrimaryKey() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = new Furn();
        furn.setId(4);
        furn.setName("平安喜乐的家具-sofa");
        int affected = furnMapper.updateByPrimaryKey(furn);
        System.out.println("affected" + affected);
        System.out.println("修改成功");
    }

    @Test
    public void updateByPrimaryKeySelective() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        FurnMapper furnMapper = ioc.getBean(FurnMapper.class);
        Furn furn = new Furn();
        furn.setId(4);
        furn.setName("平安喜乐的家具-sofa");
        int affected = furnMapper.updateByPrimaryKeySelective(furn);
        System.out.println("affected" + affected);
        System.out.println("修改成功");
    }
}
