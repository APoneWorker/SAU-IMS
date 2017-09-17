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
        HttpSession session = request.getSession();

        //是否已登录,否则退回到首页
        if (session.getAttribute("userCode") == null) {
            request.getRequestDispatcher("/login.html").forward(request, response);
            return false;
        }

        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o,
                           ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
