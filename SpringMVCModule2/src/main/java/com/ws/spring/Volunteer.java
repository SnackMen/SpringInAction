package com.ws.spring;

/**
 * Created by laowang on 16-10-12.
 */
public class Volunteer implements Thinker {
    private String thoughts;
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }
    public String getThoughts(){
        return thoughts;
    }
}
