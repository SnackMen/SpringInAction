package com.ws.spring;

import com.ws.configuration.SpringIdolConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by laowang on 16- 10-9.
 */
public class Play {
    public static void main(String []args) throws PerformanceException {
//        ApplicationContext ctx= new ClassPathXmlApplicationContext("spring-config.xml");
////        Instrument instrument = (Instrument)ctx.getBean("guitar");
////        instrument.play();
//        Performer performer = (Performer)ctx.getBean("duke");
//        performer.perform();
        SpringIdolConfig springIdolConfig = new SpringIdolConfig();
        Performer performer = springIdolConfig.poeticDuke();
        performer.perform();


    }
}
