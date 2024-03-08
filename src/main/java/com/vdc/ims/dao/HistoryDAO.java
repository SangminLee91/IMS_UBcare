package com.vdc.ims.dao;

import com.vdc.ims.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("historyDAO")
public class HistoryDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getHistTotCnt(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "hist.getHistTotCnt", map);
    } 
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getHistSrchCnt(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "hist.getHistSrchCnt", map);
    } 
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getHistData(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "hist.getHistData", map);
    } 

    public void addHist(Map<String, Object> map) throws Exception{
        insert(sqlSession, "hist.addHist", map);
    }

}
