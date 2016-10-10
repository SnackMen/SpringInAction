package com.ws.spring;

/**
 * Created by laowang on 16-10-9.
 */
public class Juggler implements Performer {
    private int beanBags = 3;
    public Juggler(){

    }
    public Juggler(int beanBags){
        this.beanBags = beanBags;
    }
    public void perform() throws PerformanceException {
        System.out.println("JUGGLING　"+beanBags+" BEANBAGS");
    }

}
