package com.ws.spring.viewresolver;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * Created by laowang on 16-10-19.
 */
public class PdfViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        PdfView view = new PdfView();
        return view;
    }

}
