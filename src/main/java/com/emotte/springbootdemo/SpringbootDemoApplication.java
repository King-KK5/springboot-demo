package com.emotte.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@EnableScheduling  //启用调度程序
@SpringBootApplication
//@MapperScan("com.emotte.springbootdemo.mybatis.mapper")  //单数据源mybatis使用
public class SpringbootDemoApplication {
//public class SpringbootDemoApplication extends SpringBootServletInitializer {   //打war包时继承
//public class SpringbootDemoApplication implements ApplicationRunner {  //应用程序启动后立即执行一些操作时实现

    //打war包时实现
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootDemoApplication.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }


    //应用程序启动后立即执行一些操作
   /* @Override
    public void run(ApplicationArguments arg0) throws Exception {
        System.out.println("Hello World from Application Runner");
    }*/

    //查看spring boot注入的bean
    /*@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }*/

    //注入bean
    //@Autowired
    //RestTemplate restTemplate;

    //注入RestTemplate
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
