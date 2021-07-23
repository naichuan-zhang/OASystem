package com.naichuan.controller;

import com.naichuan.service.SysLoginService;
import com.naichuan.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Naichuan Zhang
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SysLoginService userLoginService;

    @PostMapping("/verification.do")
    public ModelAndView login(String username, String password,
                              @RequestParam(defaultValue = "0000") String verificationCode,
                              Model model, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        String msg;
        HttpSession session = request.getSession();
        String sessionVerificationCode = "0000";
        if (sessionVerificationCode != null && sessionVerificationCode.equals(verificationCode)) {
            session.setAttribute("verificationCode", MD5Utils.md5(Math.random() + ""));
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);

            } catch (IncorrectCredentialsException e) {
                msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
                model.addAttribute("message", msg);
                System.out.println(msg);
                mav.setViewName("redirect:/index.jsp");
            } catch (ExcessiveAttemptsException e) {
                msg = "登录失败次数过多";
                model.addAttribute("message", msg);
                System.out.println(msg);
                mav.setViewName("redirect:/index.jsp");
            } catch (LockedAccountException e) {
                msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
                model.addAttribute("message", msg);
                System.out.println(msg);
                mav.setViewName("redirect:/index.jsp");
            } catch (DisabledAccountException e) {
                msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
                model.addAttribute("message", msg);
                System.out.println(msg);
                mav.setViewName("redirect:/index.jsp");
            } catch (ExpiredCredentialsException e) {
                msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
                model.addAttribute("message", msg);
                System.out.println(msg);
                mav.setViewName("redirect:/index.jsp");
            } catch (UnknownAccountException e) {
                msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
                model.addAttribute("message", msg);
                System.out.println(msg);
                mav.setViewName("redirect:/index.jsp");
            } catch (UnauthorizedException e) {
                msg = "您没有得到相应的授权！" + e.getMessage();
                model.addAttribute("message", msg);
                System.out.println(msg);
                mav.setViewName("redirect:/index.jsp");
            }
        } else {
            mav.addObject("msg", "验证码错误！");
            mav.setViewName("redirect:/index.jsp");
        }
        return mav;
    }
}
