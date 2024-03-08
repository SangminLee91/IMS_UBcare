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
@Repository("mngIvrDAO")
public class MngIvrDAO extends AbstractDAO{

    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;

	//음원 목록
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> VoiceList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.VoiceList", map);
    }
    
	//음원 ServiceID 검사
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ServiceIDCheck(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.ServiceIDCheck", map);
    }
    
    //ServiceTTSReg
    public void ServiceTTSReg(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ServiceTTSReg", map);
    }
    
    //ServiceFileAdd
    public void ServiceFileAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ServiceFileAdd", map);
    }
    
    //ServiceFileDel
    public void ServiceFileDel(Map<String, Object> map) throws Exception{
    	update(sqlSession, "mngIvr.ServiceFileDel", map);
    }
    //ServiceDescUpdate
    public void ServiceDescUpdate(Map<String, Object> map) throws Exception{
    	update(sqlSession, "mngIvr.ServiceDescUpdate", map);
    }
    //ServiceDescUpdate
    public void ServiceFileUpdate(Map<String, Object> map) throws Exception{
    	update(sqlSession, "mngIvr.ServiceFileUpdate", map);
    }

    public Map<String, Object> ServiceMaxPrompt(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.getMaxPrompt", map);
    }

	//HolidaySet List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> HolidaySetList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.HolidaySetList", map);
    }
    
	//Holiday List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> HolidayList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.HolidayList", map);
    }
    
    //HolidaySetAdd
    public void HolidaySetAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.HolidaySetAdd", map);
    }
    //HolidaySetUpdate
    public void HolidaySetUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.HolidaySetUpdate", map);
    }
    //HolidaySetDel
    public void HolidaySetDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.HolidaySetDel", map);
    }
    
    //HolidayAdd
    public void HolidayAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.HolidayAdd", map);
    }
    //HolidayUpdate
    public void HolidayUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.HolidayUpdate", map);
    }
    //HolidatDel
    public void HolidayDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.HolidayDel", map);
    }
    
    //WorkhourSet List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> WorkhourSetList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.WorkhourSetList", map);
    }
    
    //WorkhourSetAdd
    public void WorkhourSetAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.WorkhourSetAdd", map);
    }
    //WorkhourSetUpdate
    public void WorkhourSetUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.WorkhourSetUpdate", map);
    }
    //WorkhourSetDel
    public void WorkhourSetDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.WorkhourSetDel", map);
    }
    
	//Workhour List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> WorkhourList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.WorkhourList", map);
    }
    
    //WorkhourAdd
    public void WorkhourAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.WorkhourAdd", map);
    }
    //WorkhourUpdate
    public void WorkhourUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.WorkhourUpdate", map);
    }
    //WorkhourDel
    public void WorkhourDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.WorkhourDel", map);
    }
    
	//Notice List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> NoticeList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.NoticeList", map);
    }
    
    //NoticeAdd
    public void NoticeAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.NoticeAdd", map);
    }
    //NoticeUpdate
    public void NoticeUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.NoticeUpdate", map);
    }
    //NoticeDel
    public void NoticeDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.NoticeDel", map);
    }
    
	//Route List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> RouteList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.RouteList", map);
    }
    //RouteAdd
    public void RouteAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.RouteAdd", map);
    }
    //RouteUpdate
    public void RouteUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.RouteUpdate", map);
    }
    //RouteDel
    public void RouteDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.RouteDel", map);
    }
    
	//MenuSet List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> MenuSetList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.MenuSetList", map);
    }
    
	//Menu List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> MenuList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.MenuList", map);
    }
    
    //MenuSetAdd
    public void MenuSetAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.MenuSetAdd", map);
    }
    //MenuSetUpdate
    public void MenuSetUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.MenuSetUpdate", map);
    }
    //MenuSetDel
    public void MenuSetDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.MenuSetDel", map);
    }
    
    //MenuAdd
    public void MenuAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.MenuAdd", map);
    }
    //MenuUpdate
    public void MenuUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.MenuUpdate", map);
    }
    //MenuDel
    public void MenuDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.MenuDel", map);
    }
    
	//Scenario List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ScenarioList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.ScenarioList", map);
    }
    
    //ScenarioAdd
    public void ScenarioAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioAdd", map);
    }
    //ScenarioUpdate
    public void ScenarioUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioUpdate", map);
    }
    //ScenarioDel
    public void ScenarioDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioDel", map);
    }
    
	//DNIS List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> DNISList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.DNISList", map);
    }
    
    //DNISAdd
    public void DNISAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.DNISAdd", map);
    }
    //DNISUpdate
    public void DNISUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.DNISUpdate", map);
    }
    //DNISDel
    public void DNISDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.DNISDel", map);
    }
    
    //getBlackList
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> getBlackList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.getBlackList", map);
    } 
    //addBlackList
    public void addBlackList(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.addBlackList", map);
    }
    //delBlackList
    public void delBlackList(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.delBlackList", map);
    }


}
