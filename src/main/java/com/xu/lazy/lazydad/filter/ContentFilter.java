package com.xu.lazy.lazydad.filter;

import com.xu.lazy.lazydad.util.Log;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器 可以判断登录等等
 */
public class ContentFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig.getInitParameter("token");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*(
        增加测试cookie
         */
//        if (servletRequest instanceof HttpServletRequest)
//        {
//            boolean hasCookie=false;
//            Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
//            if (cookies!=null) {
//                for (Cookie cookie :cookies ) {
//                    if(cookie.getName().equals("userName"))
//                    {
//                        hasCookie=true;
//                    }
//                    Log.log("-------"+cookie.getName()+"----"+cookie.getValue());
//                }
//            }
////            if (!hasCookie) {
////                servletResponse.getWriter().write("login frist");
////            }else
////            {
////                filterChain.doFilter(servletRequest,servletResponse);
////            }
//
//
//        }
        filterChain.doFilter(servletRequest,servletResponse);
        //
    }

    @Override
    public void destroy() {

    }
}
