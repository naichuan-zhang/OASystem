package com.naichuan.mapper;

import com.naichuan.entity.SysLogin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Naichuan Zhang
 */
@Mapper
public interface SysLoginMapper {

    SysLogin selectByUsername(String username);
}
