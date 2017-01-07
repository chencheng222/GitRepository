package com.cc.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 滴水藏海 on 2016/12/5.
 */
public class springTest {

    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testSessionFactory(){
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
        System.out.println(sessionFactory);
    }

    public void testTransaction(){

    }
}
