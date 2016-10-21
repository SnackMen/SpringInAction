package com.ws.spring.controller;

import com.ws.spring.model.SDBSCollectionModel;
import com.ws.spring.service.SDBSTestService;
import com.ws.spring.service.SDBSTestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by laowang on 16-10-21.
 */
@Controller
public class AppTestController {

    @Autowired
    SDBSTestService service;

    @Autowired
    SDBSTestServiceImpl testService;

    @RequestMapping(value = "/getMessage",method = RequestMethod.GET)
    public String getMessage(ModelMap modelMap){
        SDBSCollectionModel sdbsCollectionModel = testService.findBySdbsNo(1);
        modelMap.addAttribute("sdbsno",sdbsCollectionModel);

        return "getmessage";
    }
}
