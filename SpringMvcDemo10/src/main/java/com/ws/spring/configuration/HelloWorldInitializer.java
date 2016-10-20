package com.ws.spring.configuration;

import com.ws.spring.filter.CORSFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created by laowang on 16-10-19.
 */
public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{HelloWorldConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    protected Filter[] getServletFilter(){
        return new Filter[]{new CORSFilter()};
    }
}
