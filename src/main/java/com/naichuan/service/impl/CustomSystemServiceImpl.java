package com.naichuan.service.impl;

import com.naichuan.service.CustomSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Naichuan Zhang
 */
@Service
public class CustomSystemServiceImpl implements CustomSystemService {

    @Autowired
    private JdbcTemplate template;

    @Override
    public List<Map<String, Object>> selectUserByRole(String group) {
        String sql = "select sl.username, sl.wxname from sys_login sl" +
                " left join sys_login_role slr on sl.username = slr.username" +
                " left join sys_role sr on sr.role_id = slr.role_id" +
                " where sr.role_pid = ?";
        return template.queryForList(sql, group);
    }
}
