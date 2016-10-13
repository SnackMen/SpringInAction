package com.ws.spring;

import org.springframework.context.annotation.Bean;

/**
 * Created by laowang on 16-10-12.
 */
public class Magician implements MindReader {
    private String thoughts;
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
