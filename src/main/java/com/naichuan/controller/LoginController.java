package com.naichuan.controller;

import com.naichuan.entity.SysLogin;
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

import javax.servlet.http.HttpSession;

/**
 * @author Naichuan Zhang
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SysLoginService sysLoginService;

    @PostMapping("/verification.do")
    public String login(String username, String password,
                        @RequestParam(defaultValue = "0000") String verificationCode,
                        HttpSession session, Model model) {
        String msg;
        String sessionVerificationCode = "0000";
        if (sessionVerificationCode != null && sessionVerificationCode.equals(verificationCode)) {
            session.setAttribute("verificationCode", MD5Utils.md5(verificationCode));
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject currentUser = SecurityUtils.getSubject();
            try {
                currentUser.login(token);
                SysLogin loginEntity = sysLoginService.selectByUsername(username);
                session.setAttribute("loginEntity", loginEntity);
                return "redirect:/home";
            } catch (IncorrectCredentialsException e) {
                msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            } catch (ExcessiveAttemptsException e) {
                msg = "登录失败次数过多";
            } catch (LockedAccountException e) {
                msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            } catch (DisabledAccountException e) {
                msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            } catch (ExpiredCredentialsException e) {
                msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            } catch (UnknownAccountException e) {
                msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            } catch (UnauthorizedException e) {
                msg = "您没有得到相应的授权！" + e.getMessage();
            }
        } else {
            msg = "验证码错误！";
        }
        model.addAttribute("message", msg);
        return "../../index";
    }

    @RequestMapping("/logout.do")
    public ModelAndView logout() {
        SecurityUtils.getSubject().logout();
        return new ModelAndView("redirect:/");
    }
}
