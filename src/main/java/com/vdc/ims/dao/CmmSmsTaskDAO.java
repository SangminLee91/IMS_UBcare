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
@Repository("cmmSmsTaskDAO")
public class CmmSmsTaskDAO extends AbstractDAO{

	@Resource(name="sqlSessionMain")
	private SqlSessionTemplate sqlSession;
	
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getThresHold(String SvrIp) {
		return (Map<String, Object>)selectOne(sqlSession, "smstask.getThresHold", SvrIp);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getProcData(String SvrIp) {
		return (List<Map<String, Object>>)selectList(sqlSession, "smstask.getProcData", SvrIp);
	}
	
	
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getServer() throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "smstask.getServer");
    }
	
	//SMS 최종 발송시간 업데이트
	public void setSendSmsDt(Map<String, Object> map) throws Exception{
		update(sqlSession, "smstask.LastSmsSendDt_u", map);
	}
	
    
    
}
