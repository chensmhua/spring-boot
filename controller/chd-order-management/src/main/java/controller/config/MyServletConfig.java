package controller.config;//package com.springboot.controller.config;
//
//import com.springboot.controller.filter.MyFilter;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
///**
// * @author ：huadong.chen
// * @ProjectName: springboot01helloword$
// * @Package: com.springboot.controller.config$
// * @ClassName: MyServletConfig$
// * @date ：Created in 2020-08-14 14:45
// * @description：服务器配置
// * @modified By：
// * @version: 1.01
// */
//@Configuration
//public class MyServletConfig {
//
//
//    @Bean
//    public FilterRegistrationBean myFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new MyFilter());
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/hello"));
//        return filterRegistrationBean;
//    }
//
//    /**
//     * 嵌入式servlet
//     * @return
//     */
//    @Bean
//    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
//                //设置端口号 该配置都失效，所有默认使用当前配置
//                configurableEmbeddedServletContainer.setPort(8086);
//            }
//        };
//    }
//}