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
@Repository("mngCtiDAO")
public class MngCtiDAO extends AbstractDAO {

    @Resource(name = "sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    @Resource(name="sqlSessionSub")
    private SqlSessionTemplate mssql;

    //상담원 사원 목록
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAgentEmp(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.getAgentEmp", map);
    }

    //상담원
    public void AgentAdd(Map<String, Object> map) throws Exception {
        insert(sqlSession, "mngCti.AgentAdd", map);
    }

    public void AgentEdt(Map<String, Object> map) throws Exception {
        update(sqlSession, "mngCti.AgentEdt", map);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> AgentDel(Map<String, Object> map) throws Exception {
        return (Map<String, Object>) selectOne(sqlSession, "mngCti.AgentDel", map);

    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> AgentKeyList(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.AgentKeyList", map);
    }


    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> GroupList(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.GroupList", map);
    }

    public void GroupAdd(Map<String, Object> map) throws Exception {
        insert(sqlSession, "mngCti.GroupAdd", map);
    }

    public void GroupEdt(Map<String, Object> map) throws Exception {
        update(sqlSession, "mngCti.GroupEdt", map);
    }

    public void GroupDel(Map<String, Object> map) throws Exception {
        update(sqlSession, "mngCti.GroupDel", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> GrantGroupList(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.grantGroupList", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> GroupEmp(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.GroupEmp", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> EmpGroup(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.EmpGroup", map);
    }

    //헌트그룹
    /*
    @SuppressWarnings("unchecked")
    public List<List<Object>> HuntList(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "mngCti.HuntList", map);
    }
    */
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> HuntListMOH(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.HuntListMOH", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> HuntListInitial(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.HuntListInitial", map);
    }


    //큐타겟
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> QueueTarget(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.QueueTarget", map);
    }

    //콜백 사용자 변경
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getMatchDept(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(mssql, "mssql.getMatchDept", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getMatchBranch(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(mssql, "mssql.getMatchBranch", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getMatchAgent(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(mssql, "mssql.getMatchAgent", map);
    }

    public void MatchAgentEdt(Map<String, Object> map) throws Exception {
        update(mssql, "mssql.MatchAgentEdt", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getMatchBranchCallback(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(mssql, "mssql.getMatchBranchCallback", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getDnisBranchList(Map<String, Object> map) throws Exception {
        return (List<Map<String, Object>>) selectList(sqlSession, "mngCti.DnisBranchList", map);
    }

    public void dnisBranchAdd(Map<String, Object> map) throws Exception {
        insert(sqlSession, "mngCti.DnisBranchAdd", map);
    }

    public void dnisBranchEdt(Map<String, Object> map) throws Exception {
        update(sqlSession, "mngCti.DnisBranchEdt", map);
    }

    public void dnisBranchDel(Map<String, Object> map) throws Exception {
        update(sqlSession, "mngCti.DnisBranchDel", map);
    }

}
