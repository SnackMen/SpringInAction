package com.ws.spring;

import java.util.Collection;
import java.util.Map;
import java.util.Properties;


/**
 * Created by laowang on 16-10-10.
 */
public class OneManband implements Performer {
    public OneManband(){

    }

    private Properties instruments;

    public void setInstruments(Properties instruments) {
        this.instruments = instruments;
    }

    public void perform() throws PerformanceException {
        for(Object object : instruments.keySet()){
            System.out.println(object + ":"+instruments.get(object));
        }
    }
}
