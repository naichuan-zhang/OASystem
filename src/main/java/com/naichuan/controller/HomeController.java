package com.naichuan.controller;

import com.naichuan.entity.SysLogin;
import com.naichuan.service.CustomSystemService;
import com.naichuan.service.PlanWorkService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author Naichuan Zhang
 */
@Controller
public class HomeController {

    @Autowired
    private PlanWorkService planWorkService;

    @Autowired
    private CustomSystemService customSystemService;

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
    @RequiresAuthentication
    public ModelAndView mainContent(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("plan/index");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        // 获取部门主管
        mav.addObject("managers", customSystemService.selectUserByRole("0"));
        // 获取最近7条上报数据
        mav.addObject("top7", planWorkService.selectPlanWorkByCreatorPaging(
                username, Optional.empty(), Optional.empty()));
        // 总数
        long count = planWorkService.selectPlanWorkCountByCreator(username);
        mav.addObject("count", count);
        mav.addObject("row", 7);
        if (count % 7 > 0) {
            mav.addObject("lastPage", count / 7 + 1);
        } else {
            mav.addObject("lastPage", count / 7);
        }
        return mav;
    }
}
