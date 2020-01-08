package com.emotte.springbootdemo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

//继承WebMvcConfigurer或WebMvcConfigurationSupport
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/yq/login") //登录页
                .excludePathPatterns("/yq/user/sendEmail") //发送邮箱
                .excludePathPatterns("/yq/user/register") //用户注册
                .excludePathPatterns("/yq/user/login"); //用户登录
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //springboot默认 static中放静态页面，而templates中放动态页面
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/"); //静态资源访问路径需加前缀
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }
}
