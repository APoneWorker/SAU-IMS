package com.fekpal.web.interceptor;

import com.fekpal.tool.role.RoleManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.lang.System.out;

/**
 * 登陆验证的拦截器
 * Created by hasee on 2017/8/20.
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * Handler执行之前调用这个方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        out.println("执行了拦截器的方法");

        //获取请求的URL
        String url = request.getRequestURI();

        //是否为公共访问资源路径，是则直接允许通过访问
        if (RoleManager.checkPublicAuthority(url)) {
            return true;
        }

        //获取session
        HttpSession session = request.getSession();

        //是否已登录,否则退回到首页
        if (session.getAttribute("userCode") == null) {
            request.getRequestDispatcher("/SAU/indexPage.html").forward(request, response);
            return false;
        }

        return true;
    }


    /**
     * Handler执行之后调用这个方法，返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o,
                           ModelAndView modelAndView) throws Exception {
    }

    /**
     * Handler执行之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
