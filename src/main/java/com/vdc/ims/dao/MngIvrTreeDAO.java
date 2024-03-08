package com.vdc.ims.dao;

import com.vdc.ims.common.dao.AbstractDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("mngIvrTreeDAO")
public class MngIvrTreeDAO extends AbstractDAO {
    @Resource(name="sqlSessionMain")
    private SqlSessionTemplate sqlSession;


    /*
     * 20210623 for scenario tree
     */

    //Scenario new get
    @SuppressWarnings("unchecked")
    public Map<String, Object> getScenarioNew(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioNewGet", map);
    }
    //Scenario new get
    @SuppressWarnings("unchecked")
    public Map<String, Object> getLastScenarioNew(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioNewGetLast", map);
    }
    //Scenario new List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ScenarioNewList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.ScenarioNewList", map);
    }

    //Scenario new List only type1
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ScenarioNewListSlim(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.ScenarioNewListSlim", map);
    }

    //ScenarioAdd new
    public void ScenarioNewAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioNewAdd", map);
    }
    //ScenarioUpdate new
    public void ScenarioNewUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioNewUpdate", map);
    }
    //Scenario next edit
    public void ScenarioNewNextUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioNewNextUpdate", map);
    }
    //Scenario next50 edit
    public void ScenarioNewNext50Update(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioNewNext50Update", map);
    }
    //ScenarioDel new
    public void ScenarioNewDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioNewDel", map);
    }

    //ScenarioWorkhour list
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ScenarioWorkhourList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.ScenarioWorkhourList", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> getLastScenarioWorkhour(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioWorkhourGetlast", map);
    }
    //ScenarioWorkhour add
    public void ScenarioWorkhourAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioWorkhourAdd", map);
    }
    //ScenarioWorkhour edit
    public void ScenarioWorkhourUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioWorkhourUpdate", map);
    }
    //ScenarioWorkhour next edit
    public void ScenarioWorkhourNextUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioWorkhourNextUpdate", map);
    }
    //ScenarioWorkhour next50 edit
    public void ScenarioWorkhourNext50Update(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioWorkhourNext50Update", map);
    }
    //ScenarioWorkhour del
    public void ScenarioWorkhourDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioWorkhourDel", map);
    }

    //ScenarioMenu
    @SuppressWarnings("unchecked")
    public Map<String, Object> getScenarioMenu(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioMenuGet", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> getLastScenarioMenu(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioMenuGetLast", map);
    }
    //ScenarioMenu add
    public void ScenarioMenuAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuAdd", map);
    }
    //ScenarioMenu update
    public void ScenarioMenuUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuUpdate", map);
    }
    //ScenarioMenu del
    public void ScenarioMenuDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuDel", map);
    }

    //ScenarioMenuSub list
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ScenarioMenuSubList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.ScenarioMenuSubList", map);
    }
    //ScenarioMenuSub add
    public void ScenarioMenuSubAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuSubAdd", map);
    }
    //ScenarioMenuSub edit
    public void ScenarioMenuSubUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuSubUpdate", map);
    }
    //ScenarioMenuSub next edit
    public void ScenarioMenuSubNextUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuSubNextUpdate", map);
    }
    //ScenarioMenuSub next50 edit
    public void ScenarioMenuSubNext50Update(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuSubNext50Update", map);
    }
    //ScenarioMenuSub del
    public void ScenarioMenuSubDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuSubDel", map);
    }

    //ScenarioRoute
    @SuppressWarnings("unchecked")
    public Map<String, Object> getScenarioRoute(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioRouteGet", map);
    }
    //ScenarioRoute add
    public void ScenarioRouteAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioRouteAdd", map);
    }
    //ScenarioRoute update
    public void ScenarioRouteUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioRouteUpdate", map);
    }
    //ScenarioRoute del
    public void ScenarioRouteDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioRouteDel", map);
    }

    //ScenarioOvercall list
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ScenarioOvercallList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.ScenarioOvercallList", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> getLastScenarioOvercall(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioOvercallGetLast", map);
    }
    //ScenarioOvercall add
    public void ScenarioOvercallAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioOvercallAdd", map);
    }
    //ScenarioOvercall edit
    public void ScenarioOvercallUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioOvercallUpdate", map);
    }
    //ScenarioOvercall next edit
    public void ScenarioOvercallNextUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioOvercallNextUpdate", map);
    }
    //ScenarioOvercall next50 edit
    public void ScenarioOvercallNext50Update(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioOvercallNext50Update", map);
    }
    //ScenarioOvercall del
    public void ScenarioOvercallDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioOvercallDel", map);
    }

    //ScenarioDtmf
    @SuppressWarnings("unchecked")
    public Map<String, Object> getScenarioDtmf(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioDtmfGet", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> getLastScenarioDtmf(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioDtmfGetLast", map);
    }
    //ScenarioDtmf add
    public void ScenarioDtmfAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioDtmfAdd", map);
    }
    //ScenarioDtmf update
    public void ScenarioDtmfUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioDtmfUpdate", map);
    }
    //ScenarioDtmf next edit
    public void ScenarioDtmfNextUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioDtmfNextUpdate", map);
    }
    //ScenarioDtmf next50 edit
    public void ScenarioDtmfNext50Update(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioDtmfNext50Update", map);
    }
    //ScenarioDtmf del
    public void ScenarioDtmfDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioDtmfDel", map);
    }

    //ScenarioCallback
    @SuppressWarnings("unchecked")
    public Map<String, Object> getScenarioCallback(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioCallbackGet", map);
    }
    @SuppressWarnings("unchecked")
    public Map<String, Object> getLastScenarioCallback(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioCallbackGetLast", map);
    }
    //ScenarioCallback add
    public void ScenarioCallbackAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioCallbackAdd", map);
    }
    //ScenarioCallback update
    public void ScenarioCallbackUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioCallbackUpdate", map);
    }
    //ScenarioCallback next edit
    public void ScenarioCallbackNextUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioCallbackNextUpdate", map);
    }
    //ScenarioCallback next50 edit
    public void ScenarioCallbackNext50Update(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioCallbackNext50Update", map);
    }
    //ScenarioCallback del
    public void ScenarioCallbackDel(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioCallbackDel", map);
    }

    //ScenarioNotice
    @SuppressWarnings("unchecked")
    public Map<String, Object> getScenarioNotice(Map<String, Object> map) throws Exception{
        return (Map<String, Object>)selectOne(sqlSession, "mngIvr.ScenarioNoticeGet", map);
    }

    //Route New List
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> RouteNewList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.RouteNewList", map);
    }
    //RouteNewAdd
    public void RouteNewAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.RouteNewAdd", map);
    }
    //RouteNewUpdate
    public void RouteNewUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.RouteNewUpdate", map);
    }

    //Route New Emergency
    public void RouteEmergencySet(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.RouteEmergencyForwardUpdate", map);
    }

    //Scenario New Emergency
    public void ScenarioEmergencySet(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioEmergencyUpdate", map);
    }

    //Scenario Callback batch list
    public List<Map<String, Object>> CallbackList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.CallbackList", map);
    }

    //Scenario Callback batch update
    public void CallbackBatchUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.CallbackBatchUpdate", map);
    }

    //Scenario MenuSub slim add
    public void ScenarioMenuSubSlimAdd(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuSubSlimAdd", map);
    }
    //Scenario MenuSub slim update
    public void ScenarioMenuSubSlimUpdate(Map<String, Object> map) throws Exception{
        insert(sqlSession, "mngIvr.ScenarioMenuSubSlimUpdate", map);
    }

    //Scenario new List only type1 by Dept
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> ScenarioNewListSlimByDept(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>)selectList(sqlSession, "mngIvr.ScenarioNewListSlimByDept", map);
    }

}
