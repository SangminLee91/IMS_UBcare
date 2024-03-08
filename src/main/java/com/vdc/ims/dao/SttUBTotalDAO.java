package com.vdc.ims.dao;

import com.vdc.ims.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Mir
 *
 */
@Repository("sttUBTotalDAO")
public class SttUBTotalDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;
	
	//총괄현황
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAll(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getAll", map);
    }

    //총괄현황 본사만
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAllHead(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getAllHead", map);
    }

    //시간대별 접촉률 - 대리점
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTime(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getTime", map);
    }

    //시간대별 접촉률 - 상담원
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getTimeAgent(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getTimeAgent", map);
    }

    //상담원 실적현황
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getUBAgentResult(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getUBAgentResult", map);
    }

    // 큐별 재통화분석
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getUBQueRecall(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getUBQueRecall", map);
    }


    // 큐별 재통화리스트
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getUBQueRecallList(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getUBQueRecallList", map);
    }


    // IVR 통계
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getUBIvrList(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getUBIvrList", map);
    }

    // 통화시간분석
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getUBCallTimeList(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttUB.getUBCallTimeList", map);
    }


}
