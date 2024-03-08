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
@Repository("sttIvrDAO")
public class SttIvrDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getServiceStat(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttIvr.getServiceStat", map);
    }
    
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getMenuStat(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttIvr.getMenuStat", map);
    }
    
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getServiceStatbyDNIS(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttIvr.getServiceStatbyDNIS", map);
    }
    
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getCallbackList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttIvr.getCallbackList", map);
    }
    
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getCallbackStat(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttIvr.getCallbackStat", map);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getCallbackType(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "sttIvr.getCallbackType", map);
    }
}
