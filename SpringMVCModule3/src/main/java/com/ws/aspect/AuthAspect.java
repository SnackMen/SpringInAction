package com.ws.aspect;

import org.aspectj.lang.annotation.*;

/**
 * Created by laowang on 16-10-12.
 */

@Aspect
public class AuthAspect {//zhu yi zheli shi yi ge lei bu shi aspect
    @Before("execution(* com.ws.impl.*.*(..))")
    public void authority(){
        System.out.println("模拟进行权限检查...");
    }
    @AfterReturning(returning = "rvt", pointcut = "execution(* com.ws.impl.*.*(..))")
    public void log(Object rvt){
        System.out.println("get target return method:"+rvt);
        System.out.println("mo ni ri zhi gong neng...");
    }
    @AfterThrowing(throwing = "ex",pointcut = "execution(* com.ws.impl.*.*(..))")
    public void doRecoveryActions(Throwable ex){
        System.out.println("throw exception:"+ex);
        System.out.println("mo ni yi chang xiu fu...");
    }
    @After("execution(* com.ws.impl.*.*(..))")
    public void release(){
        System.out.println("release");
    }
}
