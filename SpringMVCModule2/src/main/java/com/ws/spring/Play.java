package com.ws.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by laowang on 16- 10-9.
 */
public class Play {
    public static void main(String []args) throws PerformanceException {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-config.xml");
        Performer performer = (Performer)ctx.getBean("carl");
        performer.perform();

    }
}
