package com.vdc.ims.dao;

import com.vdc.ims.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("acntDAO")
public class AcntDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;
	
	//권한에 따른 사원정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getEmp(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getEmp", map);
    }
   
    //권한에 따른 부서정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDept(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getDept", map);
    }  
    
	//전체 사원정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTotalEmp(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getTotalEmp", map);
    }
   
    //전체 부서정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTotalDept(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getTotalDept", map);
    }
    
    //상담원 사원 목록
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAgentEmp(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getAgentEmp", map);
    }

    //권한에 따른 Que
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getGrantQue(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getGrantQue", map);
    }
    
    //권한에 따른 CalledNumber
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getGrantCalled(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getGrantCalled", map);
    }
    
    //상담원 어플리케이션 계정 정보 동기화
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAppSyncEmp(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getAppSyncEmp", map);
    }
    
    //상담원 어플리케이션 계정 정보 동기화
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSMSMsg(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "acnt.getSMSMsg", map);
    }
 
    //상담원 상세 정보
    @SuppressWarnings("unchecked")
    public Map<String, Object> getEmpDtl(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "acnt.getEmpDtl", map);
    }
    
    @SuppressWarnings("unchecked")
    public Map<String, Object> getTransTree(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "acnt.getTransTree", map);
    } 
    
    public void setOracleSync(Map<String, Object> map) throws Exception{
    	update(sqlSession, "acnt.setOracleSync", map);
    }  
    
    
}
