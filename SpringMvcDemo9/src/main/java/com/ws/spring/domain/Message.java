package com.ws.spring.domain;

/**
 * Created by laowang on 16-10-19.
 */
public class Message {
    String name;
    String text;

    public Message(String name,String text){
        this.name = name;
        this.text = text;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
