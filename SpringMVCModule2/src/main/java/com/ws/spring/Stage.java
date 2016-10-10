package com.ws.spring;

/**
 * Created by laowang on 16-10-9.
 */
public class Stage {
    private Stage(){

    }
    private static class StageSingleetonHolder{
        static Stage instance = new Stage();
    }
    public static Stage getInstance(){
        return StageSingleetonHolder.instance;
    }
}
