package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.vdc.ims.dao.CodeDAO;
import com.vdc.ims.service.CodeService;
import org.springframework.stereotype.Service;

 
@Service("codeService")
public class CodeServiceImpl implements CodeService {

    @Resource(name="codeDAO")
    private CodeDAO codeDAO;
    
    //공통코드
    @Override
    public List<Map<String, Object>> CmmCodeList(Map<String, Object> map) throws Exception {
        return codeDAO.CmmCodeList(map);
    }
    public void CmmCodeAdd(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CmmCodeAdd(map);
    }
    public void CmmCodeEdt(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CmmCodeEdt(map);
    }
    public void CmmCodeDel(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CmmCodeDel(map);
    }
    
    //공통코드 상세
    @Override
    public List<Map<String, Object>> CmmCodeDtlList(Map<String, Object> map) throws Exception {
        return codeDAO.CmmCodeDtlList(map);
    }
    public void CmmCodeDtlAdd(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CmmCodeDtlAdd(map);
    }
    public void CmmCodeDtlEdt(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CmmCodeDtlEdt(map);
    }
    public void CmmCodeDtlDel(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CmmCodeDtlDel(map);
    } 

    //Dept
    public void DeptAdd(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.DeptAdd(map);
    }
    public void DeptEdt(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.DeptEdt(map);
    }
    public void DeptDel(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.DeptDel(map);
    }

    @Override
    public Map<String, Object> DeptName(Map<String, Object> map) throws Exception {
        return codeDAO.DeptName(map);
    }
    
    
    
    //Queue Code 
    @Override
    public List<Map<String, Object>> CodeQueueList(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return codeDAO.CodeQueueList(map);
    }
    public void CodeQueueAdd(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CodeQueueAdd(map);
    }
    public void CodeQueueEdt(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CodeQueueEdt(map);
    }
    public void CodeQueueDel(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CodeQueueDel(map);
    }
    
    //CalledNumber Code 
    @Override
    public List<Map<String, Object>> CodeCalledNumberList(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return codeDAO.CodeCalledNumberList(map);
    }
    public void CodeCalledNumberAdd(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CodeCalledNumberAdd(map);
    }
    public void CodeCalledNumberEdt(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CodeCalledNumberEdt(map);
    }
    public void CodeCalledNumberDel(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        codeDAO.CodeCalledNumberDel(map);
    }  
    
    
 	//IMS_IFX VirtualGroups
    @Override
    public List<Map<String, Object>> VirtualGroupsList(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return codeDAO.VirtualGroupsList(map);
    }
	//IMS_IFX Teams
    @Override
    public List<Map<String, Object>> TeamsList(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return codeDAO.TeamsList(map);
    }
	//IMS_IFX CallType
    @Override
    public List<Map<String, Object>> CallTypeList(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return codeDAO.CallTypeList(map);
    }
	//IMS_IFX Monitoredresources
    @Override
    public List<Map<String, Object>> MonitoredresourcesList(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
        return codeDAO.MonitoredresourcesList(map);
    }
    
    
}
