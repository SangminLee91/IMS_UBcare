package com.vdc.ims.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.vdc.ims.common.dao.AbstractDAO;

/**
 * @author Mir
 *
 */
@Repository("cmmRestApiDAO")
public class CmmRestApiDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    @Resource(name="sqlSessionSub")
    private SqlSessionTemplate mssql;

	//권한에 따른 사원정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getEmp(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getEmp", map);
    }

    //권한에 따른 부서정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDept(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getDept", map);
    }

    public List<Map<String, Object>> getUserGroup(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(mssql, "cmmRestApi.getUserGroup", map);
    }

	//전체 사원정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTotalEmp(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getTotalEmp", map);
    }

    //전체 부서정보
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTotalDept(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getTotalDept", map);
    }


    //권한에 따른 Que
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getGrantQue(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getGrantQue", map);
    }

    //권한에 따른 CalledNumber
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getGrantCalled(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getGrantCalled", map);
    }

    //상담원 어플리케이션 계정 정보 동기화
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAppSyncEmp(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getAppSyncEmp", map);
    }

    //상담원 어플리케이션 계정 정보 동기화
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSMSMsg(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getSMSMsg", map);
    }

    //상담원 상세 정보
    @SuppressWarnings("unchecked")
    public Map<String, Object> getEmpDtl(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "cmmRestApi.getEmpDtl", map);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getTransTree(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "cmmRestApi.getTransTree", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getGrantBranch(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getGrantBranch", map);
    }


    public void setOracleSync(Map<String, Object> map) throws Exception{
    	update(sqlSession, "cmmRestApi.setOracleSync", map);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getApiWaitCall(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "cmmRestApi.getApiWaitCall", map);
    }

    public List<Map<String, Object>> getCallBack(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "cmmRestApi.getCallBack", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> requestService(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>) selectList(mssql, "mssql.requestService", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDeptFromDnis(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>) selectList(sqlSession, "cmmRestApi.getDeptFromDnis", map);
    }


}
