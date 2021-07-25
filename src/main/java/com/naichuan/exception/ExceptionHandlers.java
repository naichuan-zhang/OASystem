package com.naichuan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Naichuan Zhang
 */
@ControllerAdvice(basePackages = "com.naichuan.controller")
public class ExceptionHandlers {

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public ModelAndView handle(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("../../500");
        mav.addObject("errMsg", e.getMessage());
        return mav;
    }
}
