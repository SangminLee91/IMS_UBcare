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
@Repository("sttCtiDAO")
public class SttCtiDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAgentData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttCti.getAgentData", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAgentHistData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttCti.getAgentHistData", map);
    }  
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAgentResultData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttCti.getAgentResultData", map);
    } 
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAgentCallData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttCti.getAgentCallData", map);
    } 
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAgentStatusData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttCti.getAgentStatusData", map);
    }  
    
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getQueueStatsData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttCti.getQueueStatsData", map);
    }   
 
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> sttAgentQueData(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttCti.sttAgentQueData", map);
    }   
}
