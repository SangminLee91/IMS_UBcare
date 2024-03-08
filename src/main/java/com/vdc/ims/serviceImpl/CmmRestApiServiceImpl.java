package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.vdc.ims.dao.CmmRestApiDAO;
import com.vdc.ims.service.CmmRestApiService;
import org.springframework.stereotype.Service;


@Service("cmmRestApiService")
public class CmmRestApiServiceImpl implements CmmRestApiService {

    @Resource(name="cmmRestApiDAO")
    private CmmRestApiDAO cmmRestApiDAO;

    @Override
    public List<Map<String, Object>> getEmp(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return cmmRestApiDAO.getEmp(map);
    }

    @Override
    public List<Map<String, Object>> getDept(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return cmmRestApiDAO.getDept(map);
    }
    @Override
    public List<Map<String, Object>> getUserGroup(Map<String, Object> map, HttpSession session) throws Exception{
        map.put("_Emp_No", session.getAttribute("Emp_No"));
        return cmmRestApiDAO.getUserGroup(map);
    }

    @Override
    public List<Map<String, Object>> getTotalEmp(Map<String, Object> map) throws Exception {
        return cmmRestApiDAO.getTotalEmp(map);
    }

    @Override
    public List<Map<String, Object>> getTotalDept(Map<String, Object> map) throws Exception {
        return cmmRestApiDAO.getTotalDept(map);
    }



    @Override
    public List<Map<String, Object>> getGrantQue(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return cmmRestApiDAO.getGrantQue(map);
    }

    @Override
    public List<Map<String, Object>> getGrantCalled(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return cmmRestApiDAO.getGrantCalled(map);
    }

    //상담원 어플리케이션 계정 정보 동기화
    @Override
    public List<Map<String, Object>> getAppSyncEmp(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_Emp_No", session.getAttribute("Emp_No"));
        return cmmRestApiDAO.getAppSyncEmp(map);
    }

    //IVR GET sms msg
    @Override
    public List<Map<String, Object>> getSMSMsg(Map<String, Object> map) throws Exception {
    	//map.put("_Emp_No", session.getAttribute("Emp_No"));
        return cmmRestApiDAO.getSMSMsg(map);
    }

    @Override
    public Map<String, Object> getEmpDtl(Map<String, Object> map) throws Exception {
        return cmmRestApiDAO.getEmpDtl(map);
    }

    @Override
    public Map<String, Object> getTransTree(Map<String, Object> map) throws Exception {
        return cmmRestApiDAO.getTransTree(map);
    }

    @Override
    public List<Map<String, Object>> getGrantBranch(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_Emp_No", session.getAttribute("Emp_No"));
        return cmmRestApiDAO.getGrantBranch(map);
    }



    @Override
    public void setOracleSync(Map<String, Object> map) throws Exception {
        cmmRestApiDAO.setOracleSync(map);
    }

    @Override
    public Map<String, Object> getApiWaitCall(Map<String, Object> map) throws Exception {
        return cmmRestApiDAO.getApiWaitCall(map);
    }

    @Override
    public List<Map<String, Object>> getCallBack(Map<String, Object> map, HttpSession session) throws Exception {
        return cmmRestApiDAO.getCallBack(map);
    }

    @Override
    public List<Map<String, Object>> requestService(Map<String, Object> map) throws Exception {
        return cmmRestApiDAO.requestService(map);
    }

    @Override
    public List<Map<String, Object>> getDeptFromDnis(Map<String, Object> map) throws Exception {
        return cmmRestApiDAO.getDeptFromDnis(map);
    }


}
