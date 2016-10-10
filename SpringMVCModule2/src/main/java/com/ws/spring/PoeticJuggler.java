package com.ws.spring;

/**
 * Created by laowang on 16-10-9.
 */
public class PoeticJuggler extends Juggler {
    private Poem poem;
    public PoeticJuggler(Poem poem){
        super();
        this.poem = poem;
    }
    public PoeticJuggler(int beanBags,Poem poem){//适用于进行构造注入
        super(beanBags);
        this.poem = poem;
    }

    public void perform()throws PerformanceException{
        super.perform();//执行父类方法
        System.out.println("While reciting...");
        poem.recite();//调用poem中的方法
    }

    public void turnOnLight(){
        System.out.println("灯亮了");
    }

    public void turnOffLight(){
        System.out.println("灯关了");
    }
}
