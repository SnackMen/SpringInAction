package com.ws.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by laowang on 16-10-12.
 */

@Aspect
public class AuthAspect {//zhu yi zheli shi yi ge lei bu shi aspect
    @Before("execution(* com.ws.impl.*.*(..))")
    public void authority(){
        System.out.println("模拟进行权限检查...");
    }
}
