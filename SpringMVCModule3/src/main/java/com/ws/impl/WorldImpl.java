package com.ws.impl;

import com.ws.spring.World;
import org.springframework.stereotype.Component;

/**
 * Created by laowang on 16-10-12.
 */
@Component("world")
public class WorldImpl implements World {
    public void bar() {
        System.out.println("执行World组件的bar()方法");
    }
}
