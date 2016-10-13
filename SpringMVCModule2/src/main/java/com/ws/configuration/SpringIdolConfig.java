package com.ws.configuration;

import com.ws.spring.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by laowang on 16-10-11.
 */
//这里相当于<beans>,在基于java的配置里使用@Configuration的注解的java类,就等价于
    //xml配置中的<beans>元素
@Configuration
public class SpringIdolConfig {
    //该注解会告知Spring,这个类将包含一个或多个SpringBean的定义,这些
    //Bean的定义是使用@Bean注解所标注的地方
    @Bean
    public Performer duke(){
        return new Juggler(15);
    }

    @Bean
    public Instrument saxophone(){
        return new Saxophone();
    }
    @Bean
    public Performer kenny(){
        Instrumentalist kenny = new Instrumentalist();
        kenny.setSong("Jingle Bells");
        kenny.setInstrument(saxophone());
        return kenny;
    }

    @Bean
    public Poem sonnet29(){
        return new Sonnet29();
    }

    @Bean
    public Performer poeticDuke(){
        return new PoeticJuggler(sonnet29());
    }
}
