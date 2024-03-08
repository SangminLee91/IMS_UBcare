package com.vdc.ims.serviceImpl;


import com.vdc.ims.dao.AcntDAO;
import com.vdc.ims.service.AcntService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Service("acntService")
public class AcntServiceImpl implements AcntService {

    @Resource(name="acntDAO")
    private AcntDAO acntDAO;

    @Override
    public List<Map<String, Object>> getEmp(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return acntDAO.getEmp(map);
    }
  
    @Override
    public List<Map<String, Object>> getDept(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return acntDAO.getDept(map);
    }

    @Override
    public List<Map<String, Object>> getTotalEmp(Map<String, Object> map) throws Exception {
        return acntDAO.getTotalEmp(map);
    }
  
    @Override
    public List<Map<String, Object>> getTotalDept(Map<String, Object> map) throws Exception {
        return acntDAO.getTotalDept(map);
    }

    @Override
    public List<Map<String, Object>> getAgentEmp(Map<String, Object> map) throws Exception {
        return acntDAO.getAgentEmp(map);
    }

    @Override
    public List<Map<String, Object>> getGrantQue(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return acntDAO.getGrantQue(map);
    }
  
    @Override
    public List<Map<String, Object>> getGrantCalled(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return acntDAO.getGrantCalled(map);
    } 
    
    //상담원 어플리케이션 계정 정보 동기화
    @Override
    public List<Map<String, Object>> getAppSyncEmp(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return acntDAO.getAppSyncEmp(map);
    } 
    
    //IVR GET sms msg
    @Override
    public List<Map<String, Object>> getSMSMsg(Map<String, Object> map) throws Exception {
    	//map.put("_Emp_No", session.getAttribute("Emp_No"));
        return acntDAO.getSMSMsg(map);
    } 
    
    @Override
    public Map<String, Object> getEmpDtl(Map<String, Object> map) throws Exception {
        return acntDAO.getEmpDtl(map);
    }  
    
    @Override
    public Map<String, Object> getTransTree(Map<String, Object> map) throws Exception {
        return acntDAO.getTransTree(map);
    }    
    
    
    @Override
    public void setOracleSync(Map<String, Object> map) throws Exception {
        acntDAO.setOracleSync(map);
    }      
    
    
}
