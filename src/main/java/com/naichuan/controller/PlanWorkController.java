package com.naichuan.controller;

import com.naichuan.entity.PlanWork;
import com.naichuan.service.PlanWorkService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Naichuan Zhang
 */
@Controller
public class PlanWorkController {

    @Autowired
    private SimpleDateFormat sdf;

    @Autowired
    private PlanWorkService planWorkService;

    @RequestMapping("/planGoToday")
    @RequiresAuthentication
    public ModelAndView goToday(HttpServletRequest request, Integer page) {
        ModelAndView mav = new ModelAndView("plan/planwork");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        // 获取最近7条上报数据
        List<PlanWork> top7 = planWorkService.selectByPlanTo(username, PlanWork.PlanFlag.FLAG_PROCESSING,
                Optional.empty(), Optional.empty());
        mav.addObject("top7", top7);
        long count = planWorkService.selectPlanToCountProcessing(username);
        mav.addObject("count", count);
        mav.addObject("row", 7);
        if (count % 7 > 0) {
            mav.addObject("lastPage", count / 7 + 1);
        } else {
            mav.addObject("lastPage", count / 7);
        }
        // 查找已完成的数据
        mav.addObject("top7Over", planWorkService.selectByPlanToFlagExclusive(username, PlanWork.PlanFlag.FLAG_PROCESSING,
                Optional.empty(), Optional.empty()));
        long countOver = planWorkService.selectPlanToCountNonProcessing(username);
        mav.addObject("countOver", countOver);
        if (countOver % 7 > 0) {
            mav.addObject("lastPageOver", countOver / 7 + 1);
        } else {
            mav.addObject("lastPageOver", countOver / 7);
        }
        return mav;
    }

    @RequestMapping("/planGoAll")
    @ResponseBody
    @RequiresAuthentication
    public Map<String, Object> goAll(HttpServletRequest request, int page) {
        Map<String, Object> map = new HashMap<>();
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int tempPage = page;
        if (tempPage > 0) {
            tempPage = (tempPage - 1) * 7;
        }
        List<PlanWork> planWorks = planWorkService.selectByPlanTo(username, PlanWork.PlanFlag.FLAG_PROCESSING,
                Optional.of(tempPage), Optional.empty());
        if (planWorks != null && planWorks.size() > 0) {
            map.put("success", true);
            map.put("data", planWorks);
            map.put("page", page);
        } else {
            map.put("success", false);
        }
        return map;
    }

    @RequestMapping("/planById")
    @ResponseBody
    public PlanWork planById(String planId) {
        return planWorkService.selectById(planId);
    }

    @RequestMapping("/updatePlanWork")
    public ModelAndView updatePlanWork(HttpServletRequest request, @RequestBody PlanWork planWork) {
        planWorkService.update(planWork.getPlanId(), PlanWork.PlanFlag.valueOf(planWork.getPlanFlag()));
        return goToday(request, null);
    }
}
