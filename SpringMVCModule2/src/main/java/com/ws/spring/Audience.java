package com.ws.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by laowang on 16-10-12.
 */
@Aspect
public class Audience {

    @Pointcut(
            "execution(* com.ws.spring.Performer.perform(..))"
    )
    public void performance(){

    }
    //表演之前
    @Before("performance()")
    public void takeSeats(){
        System.out.println("The audience is taking their seats.");
    }
    @Before("performance()")
    public void turnOffCellPhones(){
        System.out.println("The audience is turning off their cellphones");
    }
    //表演之后
    @AfterReturning("performance()")
    public void  applaud(){
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    //表演失败之后
    @AfterThrowing("performance()")
    public void demainRefund(){
        System.out.println("BOO! We want our money back!");
    }

    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try{
            System.out.println("The audience is taking their seats.");
            System.out.println("The audience is turning off their cellphones");
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("CLAP CLAP CLAP CLAP CLAP");
            System.out.println("The performance took "+(end-start)+" milliscends");
        }catch (Throwable t){
            System.out.println("Boo! We want our money back!");
        }
    }
}
