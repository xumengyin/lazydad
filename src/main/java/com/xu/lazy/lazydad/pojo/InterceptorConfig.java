package com.xu.lazy.lazydad.pojo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xu.lazy.lazydad.util.JsonUtil;
import com.xu.lazy.lazydad.util.Log;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                Log.log("HandlerInterceptor preHandle");
                boolean hasCookie=false;
                Cookie[] cookies = request.getCookies();
                if (cookies!=null) {
                    for (Cookie cookie :cookies ) {
                        if(cookie.getName().equals("userName"))
                        {
                            hasCookie=true;
                        }
                        Log.log("-------"+cookie.getName()+"----"+cookie.getValue());
                    }
                }
                //response.setCharacterEncoding("utf-8");

                //response.setContentType("text/html; charset=utf-8");
                if(!hasCookie)
                {
                    Response err =Response.fail(-1,"请先登录");
                    PrintWriter writer = response.getWriter();
                    writer.write(JsonUtil.classToJson(err));
                    writer.flush();
                    writer.close();
                }
                return hasCookie;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                Log.log("HandlerInterceptor postHandle");
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                Log.log("HandlerInterceptor afterCompletion");
                if (ex != null)
                    Log.log("HandlerInterceptor afterCompletion" + ex.toString());
            }
        }).addPathPatterns("/**").excludePathPatterns("/login");
        registry.addWebRequestInterceptor(new WebRequestInterceptor() {
            @Override
            public void preHandle(WebRequest request) throws Exception {
                Log.log("WebRequestInterceptor preHandle");
            }

            @Override
            public void postHandle(WebRequest request, ModelMap model) throws Exception {
                Log.log("WebRequestInterceptor postHandle");
            }

            @Override
            public void afterCompletion(WebRequest request, Exception ex) throws Exception {
                Log.log("WebRequestInterceptor afterCompletion");

            }
        }).addPathPatterns("/b");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加转发 setViewName 不能为error 可能为关键词
        registry.addViewController("/c").setViewName("err");
    }
}
