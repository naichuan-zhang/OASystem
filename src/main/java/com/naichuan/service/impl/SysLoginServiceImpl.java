package com.naichuan.service.impl;

import com.naichuan.entity.SysLogin;
import com.naichuan.mapper.SysLoginMapper;
import com.naichuan.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Naichuan Zhang
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private SysLoginMapper sysLoginMapper;

    @Override
    public SysLogin selectByUsername(String username) {
        return sysLoginMapper.selectByUsername(username);
    }
}
