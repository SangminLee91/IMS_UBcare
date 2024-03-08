package com.vdc.ims.service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface CmmLoginService {
    Map<String, Object> LoginChk(Map<String, Object> map) throws Exception;
    Map<String, Object> PasswdChange(Map<String, Object> map, HttpSession session) throws Exception;
    List<Map<String, Object>> getMenu(Map<String, Object> map) throws Exception;

}