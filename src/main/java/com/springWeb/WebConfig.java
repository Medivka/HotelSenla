package com.springWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;

    @Autowired
    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("webapp/WEB-INF/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
