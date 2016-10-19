package com.ws.spring.viewresolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * Created by laowang on 16-10-19.
 */
public class ExcelViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        ExcelView view = new ExcelView();
        return view;
    }
}
