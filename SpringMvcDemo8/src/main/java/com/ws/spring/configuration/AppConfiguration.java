package com.ws.spring.configuration;

import com.ws.spring.model.Pizza;
import com.ws.spring.viewresolver.ExcelViewResolver;
import com.ws.spring.viewresolver.Jaxb2MarshallingXmlViewResolver;
import com.ws.spring.viewresolver.JsonViewResolver;
import com.ws.spring.viewresolver.PdfViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laowang on 16-10-19.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.ws.spring")
public class AppConfiguration extends WebMvcConfigurerAdapter {

//    configure ContentNegotiationManager
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        configurer.ignoreAcceptHeader(true).defaultContentType(
                MediaType.TEXT_HTML
        );
    }

    //Configure ContentNegotiaytingViewResolver
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        List<ViewResolver> resolvers = new ArrayList<>();
        resolvers.add(jaxb2MarshallingXmlViewResolver());
        resolvers.add(jsonViewResolver());
        resolvers.add(jspViewResolver());
        resolvers.add(pdfViewResolver());
        resolvers.add(excelViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }


    //Configure View resolver to provide XML output Uses JAXB2 marshaller

    @Bean
    public ViewResolver jaxb2MarshallingXmlViewResolver(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Pizza.class);
        return new Jaxb2MarshallingXmlViewResolver(marshaller);
    }

    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResolver();
    }

    @Bean
    public ViewResolver pdfViewResolver() {
        return new PdfViewResolver();
    }

    /*
     * Configure View resolver to provide XLS output using Apache POI library to
     * generate XLS output for an object content
     */
    @Bean
    public ViewResolver excelViewResolver() {
        return new ExcelViewResolver();
    }

    /*
     * Configure View resolver to provide HTML output This is the default format
     * in absence of any type suffix.
     */
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
