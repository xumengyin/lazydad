package com.xu.lazy.lazydad.pojo;

import com.xu.lazy.lazydad.filter.Content2Filter;
import com.xu.lazy.lazydad.filter.ContentFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean<ContentFilter> registrationBean()
    {
        FilterRegistrationBean<ContentFilter> bean = new FilterRegistrationBean<>(new ContentFilter());

        bean.addUrlPatterns("/*");
        Map<String,String> params =new HashMap<>();
        params.put("token", UUID.randomUUID().toString());
        bean.setInitParameters(params);
        bean.setOrder(1);
        return bean;
    }
    @Bean
    public FilterRegistrationBean<Content2Filter> registrationBean2()
    {
        FilterRegistrationBean<Content2Filter> bean = new FilterRegistrationBean<>(new Content2Filter());

        bean.addUrlPatterns("/*");
//        Map<String,String> params =new HashMap<>();
//        params.put("token", UUID.randomUUID().toString());
//        bean.setInitParameters(params);
        bean.setOrder(100);
        return bean;
    }
}
