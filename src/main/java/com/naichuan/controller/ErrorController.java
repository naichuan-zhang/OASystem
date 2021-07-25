package com.naichuan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Naichuan Zhang
 */
@Controller
public class ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleErrors(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("../../error");
        Map<String, Object> map = new HashMap<>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason", request.getAttribute("javax.servlet.error.message"));
        mav.addObject("map", map);
        return mav;
    }
}
