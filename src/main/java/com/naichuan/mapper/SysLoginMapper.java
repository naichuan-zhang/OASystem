package com.naichuan.mapper;

import com.naichuan.entity.SysLogin;

public interface SysLoginMapper {

    SysLogin selectByUsername(String username);
}
