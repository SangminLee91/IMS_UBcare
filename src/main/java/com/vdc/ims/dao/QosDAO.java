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
@Repository("qosDAO")
public class QosDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

	//Subscribers Data
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSubscribers(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "qos.getSubscribers", map);
    } 
	//Subscriber r-value data
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getSubscribersQOS(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "qos.getSubscribersQOS", map);
    }
}
