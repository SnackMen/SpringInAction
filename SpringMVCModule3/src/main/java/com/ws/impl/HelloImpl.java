package com.ws.impl;

import com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationException;
import com.ws.spring.Hello;
import org.springframework.stereotype.Component;

/**
 * Created by laowang on 16-10-12.
 */
@Component("hello")
public class HelloImpl implements Hello {
    @Override
    public void foo() {
        System.out.println("执行Hello组件的foo()方法");
    }

    @Override
    public void addUser(String name, String pass) {
        System.out.println("执行Hello组件的addUser()方法添加用户:"+name);
//        if(name.length() < 3 || name.length()>10){
//            throw  new IllegalArgumentException("name's length < 3 || length >10!");
//        }
    }
}
