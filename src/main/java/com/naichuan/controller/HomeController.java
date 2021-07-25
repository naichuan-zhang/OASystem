package com.naichuan.controller;

import com.naichuan.entity.SysLogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Naichuan Zhang
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public ModelAndView modelAndView() {
        ModelAndView mav = new ModelAndView();
        Session session = SecurityUtils.getSubject().getSession(false);
        SysLogin loginEntity = ((SysLogin) session.getAttribute("loginEntity"));
        if (loginEntity != null) {
            mav.addObject("loginEntity", loginEntity);
            mav.setViewName("main");
        } else {
            mav.addObject("message", "请先登录！");
            mav.setViewName("../../index");
        }
        return mav;
    }

    @RequestMapping("/mainContent")
    @ResponseBody
    public String mainContent() {
        // TODO impl later.
        return null;
    }
}
