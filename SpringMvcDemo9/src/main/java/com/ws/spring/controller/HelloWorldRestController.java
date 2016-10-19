package com.ws.spring.controller;

import com.ws.spring.domain.Message;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by laowang on 16-10-19.
 */
//使用restController说明这个控制器不再返回view而是返回一个domain/pojo对象,在本例中返回一个JSON格式
@RestController
public class HelloWorldRestController {
    @RequestMapping("/hello/{player}")
    public Message message(@PathVariable String player){
        Message msg = new Message(player,"Hello "+player);
        return msg;
    }
}
