package controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.controller.interceptor$
 * @ClassName: WebMacInterceptor$
 * @date ：Created in 2020-08-12 20:27
 * @description： 登录检查
 * @modified By：
 * @version: 1.01
 */
@Component
public class WebMacInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object loginUser = httpServletRequest.getSession().getAttribute("loginUser");
        if (loginUser == null){
            //登录失败
            httpServletRequest.setAttribute("msg","登录失败");
        }else {
            //登录成功
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}