package com.ws.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by laowang on 16-10-10.
 */
public class Instrumentalist implements Performer {
    public Instrumentalist(){

    }
    private String song;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
    private Instrument instrument;

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void perform() throws PerformanceException {
        System.out.print("Playing "+song+" :");
        instrument.play();
    }

}
