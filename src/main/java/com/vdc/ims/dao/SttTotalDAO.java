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
@Repository("sttTotalDAO")
public class SttTotalDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;
	
	//수신
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getInCallStat(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttTotal.getInCallStat", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getInCallDtl(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttTotal.getInCallDtl", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> getInCallDtlCnt(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne(sqlSession, "sttTotal.getInCallDtlCnt", map);
    }
    
   
    //포기
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAbandonStat(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttTotal.getAbandonStat", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAbandonDtl(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttTotal.getAbandonDtl", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> getAbandonDtlCnt(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne(sqlSession, "sttTotal.getAbandonDtlCnt", map);
    }

    //유비케어용 포기호 엑셀 다운로드
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getAbandonDtlExcel(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttTotal.getAbandonDtlExcel", map);
    }


    //발신
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOutCallStat(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttTotal.getOutCallStat", map);
    }
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getOutCallDtl(Map<String, Object> map) throws Exception{
        return selectList(sqlSession, "sttTotal.getOutCallDtl", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> getOutCallDtlCnt(Map<String, Object> map) throws Exception{
        return (Map<String, Object>) selectOne(sqlSession, "sttTotal.getOutCallDtlCnt", map);
    }
}
