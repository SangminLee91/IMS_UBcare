package com.vdc.ims.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.vdc.ims.dao.MngCtiDAO;
import com.vdc.ims.service.MngCtiService;
import org.springframework.stereotype.Service;

 
@Service("mngCtiService")
public class MngCtiServiceImpl implements MngCtiService {

    @Resource(name="mngCtiDAO")
    private MngCtiDAO mngCtiDAO;

    @Override
    public List<Map<String, Object>> getAgentEmp(Map<String, Object> map) throws Exception {
        return mngCtiDAO.getAgentEmp(map);
    }

    //상담원
    public void AgentAdd(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	mngCtiDAO.AgentAdd(map);
    }
    public void AgentEdt(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	mngCtiDAO.AgentEdt(map);
    }
    @Override
    public Map<String, Object> AgentDel(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mngCtiDAO.AgentDel(map);
    } 
   
    
    @Override
    public List<Map<String, Object>> AgentKeyList(Map<String, Object> map) throws Exception {
        return mngCtiDAO.AgentKeyList(map);
    }
    
    
    //상담원 그룹
    @Override
    public List<Map<String, Object>> GroupList(Map<String, Object> map) throws Exception {
        return mngCtiDAO.GroupList(map);
    }
    public void GroupAdd(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	mngCtiDAO.GroupAdd(map);
    }
    public void GroupEdt(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	mngCtiDAO.GroupEdt(map);
    }
    public void GroupDel(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	mngCtiDAO.GroupDel(map);
    }
    public List<Map<String, Object>> GrantGroupList(Map<String, Object> map, HttpSession session) throws Exception {
    	map.put("_EMP_NO", session.getAttribute("Emp_No"));
    	return mngCtiDAO.GrantGroupList(map);
    }
    
    @Override
    public List<Map<String, Object>> GroupEmp(Map<String, Object> map) throws Exception {
        return mngCtiDAO.GroupEmp(map);
    }
    @Override
    public List<Map<String, Object>> EmpGroup(Map<String, Object> map) throws Exception {
        return mngCtiDAO.EmpGroup(map);
    }
    
    //헌트그룹
    /*
    @Override
    public List<List<Object>> HuntList(Map<String, Object> map) throws Exception {
        return mngCtiDAO.HuntList(map);
    }
    */
    @Override
    public List<Map<String, Object>> HuntListMOH(Map<String, Object> map) throws Exception {
        return mngCtiDAO.HuntListMOH(map);
    }
    @Override
    public List<Map<String, Object>> HuntListInitial(Map<String, Object> map) throws Exception {
        return mngCtiDAO.HuntListInitial(map);
    }
    
    //큐타겟
    @Override
    public List<Map<String, Object>> QueueTarget(Map<String, Object> map) throws Exception {
        return mngCtiDAO.QueueTarget(map);
    }

    //콜백 사용자 변경
    @Override
    public List<Map<String, Object>> getMatchDept(Map<String, Object> map) throws Exception {
        return mngCtiDAO.getMatchDept(map);
    }
    @Override
    public List<Map<String, Object>> getMatchBranch(Map<String, Object> map) throws Exception {
        return mngCtiDAO.getMatchBranch(map);
    }
    @Override
    public List<Map<String, Object>> getMatchAgent(Map<String, Object> map) throws Exception {
        return mngCtiDAO.getMatchAgent(map);
    }
    public void MatchAgentEdt(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        mngCtiDAO.MatchAgentEdt(map);
    }
    @Override
    public List<Map<String, Object>> getMatchBranchCallback(Map<String, Object> map) throws Exception {
        return mngCtiDAO.getMatchBranchCallback(map);
    }

    @Override
    public List<Map<String, Object>> getDnisBranchList(Map<String, Object> map) throws Exception {
        return mngCtiDAO.getDnisBranchList(map);
    }

    @Override
    public void dnisBranchAdd(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        mngCtiDAO.dnisBranchAdd(map);
    }

    @Override
    public void dnisBranchEdt(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        mngCtiDAO.dnisBranchEdt(map);
    }

    @Override
    public void dnisBranchDel(Map<String, Object> map, HttpSession session) throws Exception {
        map.put("_EMP_NO", session.getAttribute("Emp_No"));
        mngCtiDAO.dnisBranchDel(map);
    }


}
