package controller.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.controller.filter$
 * @ClassName: MyFilter$
 * @date ：Created in 2020-08-14 14:56
 * @description：过滤器
 * @modified By：
 * @version: 1.01
 */
@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter going...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}