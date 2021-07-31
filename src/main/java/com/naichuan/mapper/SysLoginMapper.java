package com.naichuan.mapper;

import com.naichuan.entity.SysLogin;

import java.util.Map;

public interface SysLoginMapper {

    SysLogin selectByUsername(String username);

    Map<String, Long> countByUsername(String username);

    int addSelective(SysLogin record);

    /**
     *
     * @param param key: role_id, login_id, username
     * @return
     */
    int addSysLoginRoleSelective(Map<String, Object> param);
}
