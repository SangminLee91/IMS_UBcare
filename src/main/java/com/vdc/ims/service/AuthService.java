package com.vdc.ims.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface AuthService {

    List<Map<String, Object>> SvcList(Map<String, Object> map) throws Exception;
    void SvcAdd(Map<String, Object> map, HttpSession session) throws Exception;
    void SvcEdt(Map<String, Object> map, HttpSession session) throws Exception;
    Map<String, Object> SvcDel(Map<String, Object> map) throws Exception;

    List<Map<String, Object>> RoleSvc(Map<String, Object> map) throws Exception;

    List<Map<String, Object>> Role(Map<String, Object> map, HttpSession session) throws Exception;
    void RoleAdd(Map<String, Object> map, HttpSession session) throws Exception;
    Object RoleEdt(Map<String, Object> map, HttpSession session) throws Exception;
    void RoleDel(Map<String, Object> map, HttpSession session) throws Exception;
    Map<String, Object> RoleSvcAdd(Map<String, Object> map) throws Exception;

    List<Map<String, Object>> RoleAndService(Map<String, Object> map) throws Exception;

    //개인 권한 서비스
    //List<Map<String, Object>> EmpSvc(Map<String, Object> map) throws Exception;
    Map<String, Object> PersonRoleAdd(Map<String, Object> map) throws Exception;
    //List<List<Object>> EmpSvc(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> getPersonSvc(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> getPersonDept(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> getPersonQue(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> getPersonCalled(Map<String, Object> map) throws Exception;
    List<Map<String, Object>> getPersonBranch(Map<String, Object> map) throws Exception;


    void GrantAdd(Map<String, Object> map, HttpSession session) throws Exception;

}
