package com.vdc.ims.serviceImpl;

import com.vdc.ims.dao.AuthDAO;
import com.vdc.ims.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service("authService")
public class AuthServiceImpl implements AuthService {

    @Resource(name="authDAO")
    private AuthDAO authDAO;

    @Override
    public List<Map<String, Object>> SvcList(Map<String, Object> map) throws Exception {
        return authDAO.SvcList(map);
    }
    @Override
    public void SvcAdd(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        authDAO.SvcAdd(map);
    }
    @Override
    public void SvcEdt(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        authDAO.SvcEdt(map);
    }
    @Override
    public Map<String, Object> SvcDel(Map<String, Object> map) throws Exception {
        return authDAO.SvcDel(map);
    }

    @Override
    public List<Map<String, Object>> RoleSvc(Map<String, Object> map) throws Exception {
        return authDAO.RoleSvc(map);
    }


    /*
     * 기본 권한 Role
     * */
    @Override
    public List<Map<String, Object>> Role(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return authDAO.Role(map);
    }
    @Override
    public void RoleAdd(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        authDAO.RoleAdd(map);
    }
    @Override
    public Object RoleEdt(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return authDAO.RoleEdt(map);
    }
    @Override
    public void RoleDel(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        authDAO.RoleDel(map);
    }
    @Override
    public Map<String, Object> RoleSvcAdd(Map<String, Object> map) throws Exception {
        return authDAO.RoleSvcAdd(map);
    }

    @Override
    public List<Map<String, Object>> RoleAndService(Map<String, Object> map) throws Exception {
        return authDAO.RoleAndService(map);
    }



    /*
     * 개인 권한 서비스
     * */
    @Override
    public List<Map<String, Object>> getPersonSvc(Map<String, Object> map) throws Exception {
        return authDAO.getPersonSvc(map);
    }
    @Override
    public List<Map<String, Object>> getPersonDept(Map<String, Object> map) throws Exception {
        return authDAO.getPersonDept(map);
    }
    @Override
    public List<Map<String, Object>> getPersonQue(Map<String, Object> map) throws Exception {
        return authDAO.getPersonQue(map);
    }
    @Override
    public List<Map<String, Object>> getPersonCalled(Map<String, Object> map) throws Exception {
        return authDAO.getPersonCalled(map);
    }
    @Override
    public List<Map<String, Object>> getPersonBranch(Map<String, Object> map) throws Exception {
        return authDAO.getPersonBranch(map);
    }



    @Override
    public Map<String, Object> PersonRoleAdd(Map<String, Object> map) throws Exception {
        return authDAO.PersonRoleAdd(map);
    }
    @Override
    public void GrantAdd(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        authDAO.GrantAdd(map);
    }

}
