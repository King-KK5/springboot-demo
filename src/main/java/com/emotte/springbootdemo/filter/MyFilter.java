package com.emotte.springbootdemo.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//先到过滤器，再到拦截器
@Component
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Remote Host:"+request.getRemoteHost());
        System.out.println("Remote Address:"+request.getRemoteAddr());
        filterChain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
