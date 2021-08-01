package com.naichuan.service;

import java.util.List;
import java.util.Map;

public interface CustomSystemService {

    List<Map<String, Object>> selectUserByRole(String group);
}
