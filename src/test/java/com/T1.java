package com;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T1 {
    @Test
    public void t1() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object dataSource = ioc.getBean("dataSource");
        System.out.println(dataSource);
        System.out.println(ioc.getBean("sqlSessionFactory"));
    }
}
