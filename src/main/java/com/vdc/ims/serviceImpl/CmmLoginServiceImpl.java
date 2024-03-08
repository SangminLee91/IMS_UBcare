package com.vdc.ims.serviceImpl;

import com.vdc.ims.dao.CmmLoginDAO;
import com.vdc.ims.service.CmmLoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service("cmmLoginService")
public class CmmLoginServiceImpl implements CmmLoginService {
    @Resource(name="cmmLoginDAO")
    private CmmLoginDAO cmmLoginDAO;

    @Override
    public Map<String, Object> LoginChk(Map<String, Object> map) {
        return cmmLoginDAO.LoginChk(map);
    }

    @Override
    public Map<String, Object> PasswdChange(Map<String, Object> map, HttpSession session) {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return cmmLoginDAO.PasswdChange(map);
    }
    @Override
    public List<Map<String, Object>> getMenu(Map<String, Object> map) throws Exception {
        return cmmLoginDAO.getMenu(map);
    }


}
