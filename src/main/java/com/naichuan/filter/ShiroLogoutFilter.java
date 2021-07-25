package com.naichuan.filter;

import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Naichuan Zhang
 */
public class ShiroLogoutFilter extends LogoutFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        return super.preHandle(request, response);
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        session.invalidate();
    }
}
