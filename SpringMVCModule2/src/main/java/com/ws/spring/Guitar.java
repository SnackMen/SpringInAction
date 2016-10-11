package com.ws.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by laowang on 16-10-11.
 */
@Component
public class Guitar implements Instrument {
    public void play() {
        System.out.println("Strum strum strum");
    }
}
