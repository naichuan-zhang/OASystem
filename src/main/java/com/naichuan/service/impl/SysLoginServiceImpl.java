package com.naichuan.service.impl;

import com.naichuan.entity.SysLogin;
import com.naichuan.mapper.SysLoginMapper;
import com.naichuan.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public Map<String, Long> countByUsername(String username) {
        return sysLoginMapper.countByUsername(username);
    }

    @Override
    public int addSelective(SysLogin record) {
        int result = 0;
        if (sysLoginMapper.addSelective(record) == 1) {
            result++;
            record = selectByUsername(record.getUsername());
            Map<String, Object> param = new HashMap<>();
            param.put("login_id", record.getLoginId());
            param.put("role_id", 3);
            param.put("username", record.getUsername());
            result += addSysLoginRoleSelective(param);
        }
        return result;
    }

    @Override
    public int addSysLoginRoleSelective(Map<String, Object> param) {
        return sysLoginMapper.addSysLoginRoleSelective(param);
    }
}
