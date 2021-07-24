package com.naichuan.controller;

import com.naichuan.entity.SysLogin;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Naichuan Zhang
 */
@Controller
public class HomeController {

    @RequestMapping("/index")
    @RequiresAuthentication
    public ModelAndView index(HttpSession session) {
        ModelAndView mav = new ModelAndView("main");
        SysLogin loginEntity = (SysLogin) session.getAttribute("loginEntity");
        mav.addObject("loginEntity", loginEntity);
        return mav;
    }
}
